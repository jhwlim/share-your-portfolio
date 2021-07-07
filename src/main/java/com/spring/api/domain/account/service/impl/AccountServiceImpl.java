package com.spring.api.domain.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.domain.account.mapper.AccountMapper;
import com.spring.api.domain.account.service.AccountService;
import com.spring.api.domain.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper mapper;
	
	@Override
	public void register(Account account) {
		mapper.register(account);
	}

}
