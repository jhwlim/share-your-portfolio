package com.spring.api.domain.auth.exception;

import org.springframework.security.core.AuthenticationException;

public class NotFoundRefreshTokenException extends AuthenticationException {

	private static final String MESSAGE = "Not Found Refresh Token";
	
	public NotFoundRefreshTokenException() {
		super(MESSAGE);
	}
	
}
