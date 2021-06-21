package com.spring.api.domain.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/account/image")
@RestController
public class AccountImageController {
	
	@GetMapping("/{accountId}")
	public ResponseEntity<byte[]> getAccountImage(@PathVariable int accountId) {
		log.info("get");
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Void> uploadAccountImage() {
		log.info("post");
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAccountImage() {
		log.info("delete");
		return null;
	}
	
}
