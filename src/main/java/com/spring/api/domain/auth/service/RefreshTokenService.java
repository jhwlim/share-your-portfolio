package com.spring.api.domain.auth.service;

import javax.servlet.http.Cookie;

import com.spring.api.domain.model.RefreshToken;

public interface RefreshTokenService {
	
	public RefreshToken generateRefreshToken(int accountId);
	
	public Cookie createRefreshTokenCookie(RefreshToken refreshToken);
	
}
