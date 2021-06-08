package com.spring.api.domain.chat.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.domain.account.service.AccountFindService;
import com.spring.api.domain.chat.model.MessageModel;
import com.spring.api.domain.chat.service.MessageSaveService;

@RestController
public class MessageController {
	
	@Autowired
	MessageSaveService service;
	
	@Autowired
	AccountFindService serviceAF;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
		
	@MessageMapping("/chat/{senderId}/{receiverId}")
	public void sendMessage(@DestinationVariable int senderId, @DestinationVariable int receiverId, MessageModel message) {
			
		System.out.println("handling send message: " + message);
		
		service.saveMessage(message);
				
		Date messageTime = service.checkTime(message.getContent());
		
		message.setCreateDate(messageTime);
				
		if(senderId != 0 && receiverId != 0) {
			simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getReceiverId(), message);
			
			simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getSenderId(), message);
			
		}
	}
	
	
}