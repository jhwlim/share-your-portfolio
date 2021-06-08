package com.spring.api.domain.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.domain.account.service.AccountFindService;
import com.spring.api.domain.chat.model.MessageModel;
import com.spring.api.domain.chat.service.MessageSaveService;

@RestController
@CrossOrigin
public class UsersController {
	
	@Autowired
	MessageSaveService service;
	
	@Autowired
	AccountFindService serviceAF;
	
	@GetMapping("/recallChat/{sender}/{receiver}")
	public List<MessageModel> recall(MessageModel msgModel, @PathVariable int sender, @PathVariable int receiver) {
			
		msgModel.setSenderId(sender);
		
		msgModel.setReceiverId(receiver);
			
		return service.recallChat(msgModel);
		
	}
	
	
}
