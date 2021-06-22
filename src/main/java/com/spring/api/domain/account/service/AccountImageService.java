package com.spring.api.domain.account.service;

import org.springframework.web.multipart.MultipartFile;

import com.spring.api.domain.account.dto.AccountImageUploadRequest;

public interface AccountImageService {

	public String findAccountImagePath(int accountId);

	public void save(MultipartFile file, int accountId, AccountImageUploadRequest request);
	
}
