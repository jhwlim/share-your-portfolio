package com.spring.api.domain.auth.service;

import javax.servlet.http.HttpServletRequest;

public interface JwtService {
	
	public String generateToken(int id, String username);
	
	public String getToken(HttpServletRequest request);
	
}
