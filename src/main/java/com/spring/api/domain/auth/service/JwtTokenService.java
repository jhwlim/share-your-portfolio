package com.spring.api.domain.auth.service;

public interface JwtTokenService {
	
	public String generateJwtToken(int id, String username);
	
}
