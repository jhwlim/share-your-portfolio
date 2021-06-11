package com.spring.api.global.security.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginRequest {

	private String username;
	private String password;
	
}
