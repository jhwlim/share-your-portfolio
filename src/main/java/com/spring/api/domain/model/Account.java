package com.spring.api.domain.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;

@Alias("Account")
@Getter
public class Account {

	private int id;
	private String email;
	private String name;
	private String password;
	private Date createdDate;
	
}
