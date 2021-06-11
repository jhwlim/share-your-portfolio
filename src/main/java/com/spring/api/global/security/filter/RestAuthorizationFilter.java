package com.spring.api.global.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.api.domain.auth.service.JwtService;
import com.spring.api.global.error.model.ErrorResponse;

import lombok.extern.log4j.Log4j;

@Log4j
public class RestAuthorizationFilter extends BasicAuthenticationFilter {

	private static final String RESPONSE_CONTENT_TYPE = "application/json;charset=utf-8";
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private JwtService jwtService;
	
	public RestAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			String accessToken = jwtService.getToken(request);
			jwtService.verify(accessToken);
			
			Authentication auth = jwtService.getAuthentication(accessToken);
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			chain.doFilter(request, response);
		} catch (Exception e) {
			log.info(e);
			
			ErrorResponse errorResponse = ErrorResponse.builder()
												.httpStatus(HttpStatus.UNAUTHORIZED)
												.message(e.getMessage())
												.build();
			
			response.setContentType(RESPONSE_CONTENT_TYPE);
			response.setStatus(errorResponse.getStatusCode());
			response.getWriter().print(objectMapper.writeValueAsString(errorResponse));
		}
		
	}
	
}
