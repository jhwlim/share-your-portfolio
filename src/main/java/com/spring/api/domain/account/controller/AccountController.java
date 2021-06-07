package com.spring.api.domain.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.domain.account.service.AccountFindService;
import com.spring.api.domain.model.Account;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class AccountController {

	@Autowired
	private AccountFindService service;
	
	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable int id) {
		return service.findAccountById(id);
	}
	
}
