package com.spring.api.domain.auth.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.spring.api.domain.model.RefreshToken;

public interface RefreshTokenService {
	
	public RefreshToken generateRefreshToken(int accountId);
	
	public Cookie createRefreshTokenCookie(RefreshToken refreshToken);

	public String getToken(HttpServletRequest request);

	public void verify(String refreshToken, int id);
	
}
