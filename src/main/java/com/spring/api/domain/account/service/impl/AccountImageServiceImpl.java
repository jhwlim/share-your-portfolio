package com.spring.api.domain.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.domain.account.mapper.AccountImageMapper;
import com.spring.api.domain.account.service.AccountImageService;

@Service
public class AccountImageServiceImpl implements AccountImageService {

	@Autowired
	private AccountImageMapper mapper;
	
	@Override
	public String findAccountImagePath(int accountId) {
		return mapper.findAccountImagePath(accountId);
	}

}
