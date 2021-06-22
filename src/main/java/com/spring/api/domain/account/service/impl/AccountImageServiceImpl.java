package com.spring.api.domain.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.api.domain.account.dto.AccountImageUploadRequest;
import com.spring.api.domain.account.mapper.AccountImageMapper;
import com.spring.api.domain.account.service.AccountImageService;
import com.spring.api.domain.model.AccountImage;

@Service
public class AccountImageServiceImpl implements AccountImageService {

	@Autowired
	private AccountImageMapper mapper;
	
	@Override
	public String findAccountImagePath(int accountId) {
		return mapper.findAccountImagePath(accountId);
	}

	@Override
	public void save(MultipartFile file, int accountId, AccountImageUploadRequest request) {
	
	}

}
