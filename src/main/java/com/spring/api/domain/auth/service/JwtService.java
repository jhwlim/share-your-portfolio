package com.spring.api.domain.auth.service;

import javax.servlet.http.HttpServletRequest;

public interface JwtService {
	
	public String generateJwtToken(int id, String username);
	
	public String getJwtToken(HttpServletRequest request);
	
}
