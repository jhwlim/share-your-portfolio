package com.spring.api.domain.chat.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.domain.account.service.AccountFindService;
import com.spring.api.domain.chat.service.ReportService;
import com.spring.api.domain.model.Report;

@RestController
public class WebController {
	
	@Autowired
	ReportService service;

	@Autowired
	AccountFindService serviceAF;
	
	/* selectAll() 메소드 미구현화로 잠시 주석 처리 !! */ 
	
//	@GetMapping("/chat")
//	public List<Account> getPage(Principal principal, Model model) {
//			
//		//List<Account> result = serviceAF.selectAll(); 
//		
//		//return result;
//		
//		
//	}
	
	@ResponseBody
	@RequestMapping(value="/report", method = RequestMethod.POST)
	public void getReport(@RequestBody Report rp) {
			
		System.out.println(rp.toString());
	
		service.saveReport(rp);
		
	}
	
}
