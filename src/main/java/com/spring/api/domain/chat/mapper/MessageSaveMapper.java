package com.spring.api.domain.chat.mapper;

import java.util.Date;
import java.util.List;

import com.spring.api.domain.chat.model.MessageModel;

public interface MessageSaveMapper {

public void saveMessage(MessageModel msgModel);
	
	public List<MessageModel> recallChat(MessageModel msgModel);
	
	public Date checkTime(String content);
}
