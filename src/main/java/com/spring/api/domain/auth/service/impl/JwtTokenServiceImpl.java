package com.spring.api.domain.auth.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.spring.api.domain.auth.config.JwtConfig;
import com.spring.api.domain.auth.service.JwtTokenService;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

	private static final String CLAIM_ID = "id";
	private static final String CLAIM_USERNAME = "username";
	
	@Autowired
	JwtConfig config;
	
	@Override
	public String generateJwtToken(int id, String username) {
		return JWT.create()
				.withClaim(CLAIM_ID, id)
				.withClaim(CLAIM_USERNAME, username)
				.withExpiresAt(new Date(System.currentTimeMillis() + config.getValidationTime()))
				.sign(Algorithm.HMAC256(config.getSecretKey()));
	}

	
}
