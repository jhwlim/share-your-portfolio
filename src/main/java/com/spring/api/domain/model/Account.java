package com.spring.api.domain.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.spring.api.global.security.model.SocialLoginRequest;

import lombok.Builder;
import lombok.Getter;

@Alias("Account")
@Getter
public class Account {

	private int id;
	private String email;
	private String name;
	private String password;
	private Date createdDate;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	@Builder
	public Account(SocialLoginRequest socialLoginRequest) {
		this.email = socialLoginRequest.getEmail();
		this.name = socialLoginRequest.getName();
	}
}
