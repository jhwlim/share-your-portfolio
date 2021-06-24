package com.spring.api.domain.account.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.spring.api.domain.account.dto.AccountImageUploadRequest;

public interface AccountImageService {

	public String findAccountImagePath(int accountId);

	public void uploadAccountImage(MultipartFile file, int accountId, AccountImageUploadRequest request) throws IOException;
	
}
