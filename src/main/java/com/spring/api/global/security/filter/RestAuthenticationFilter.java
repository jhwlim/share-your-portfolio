package com.spring.api.global.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.api.global.security.model.LoginDetails;
import com.spring.api.global.security.model.LoginRequest;

import lombok.extern.log4j.Log4j;

@Log4j
public class RestAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		log.info("attempt login...");
		
		LoginRequest loginRequest = null;
		try {
			loginRequest = objectMapper.readValue(request.getReader(), LoginRequest.class);
		} catch (IOException e) {
			log.warn(e.getMessage());
			throw new AuthenticationServiceException("request data can't be parsed");
		}
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
		return getAuthenticationManager().authenticate(authToken);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		log.info("login success!");
		LoginDetails user = (LoginDetails) authResult.getPrincipal();
		
		response.getWriter().println(objectMapper.writeValueAsString(user));
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		log.warn("login fail!");
		response.setStatus(HttpStatus.BAD_REQUEST.value());
	}
	
}
