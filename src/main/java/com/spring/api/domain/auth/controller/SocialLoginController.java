package com.spring.api.domain.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SocialLoginController {
	
	@GetMapping("/naver")
	public String naverLogin() {
		return "OK";
	}
	
}
