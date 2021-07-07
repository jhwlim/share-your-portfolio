package com.spring.api.global.security.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SocialLoginRequest {
	
	private String email;
	private String name;
	
}
