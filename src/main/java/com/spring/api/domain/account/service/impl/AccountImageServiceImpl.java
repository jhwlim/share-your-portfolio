package com.spring.api.domain.account.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.api.domain.account.dto.AccountImageUploadRequest;
import com.spring.api.domain.account.mapper.AccountImageMapper;
import com.spring.api.domain.account.service.AccountImageService;
import com.spring.api.domain.model.AccountImage;
import com.spring.api.global.util.file.FileUtils;

@Service
public class AccountImageServiceImpl implements AccountImageService {

	@Autowired
	private AccountImageMapper mapper;

	@Autowired
	private FileUtils fileUtils;
	
	@Value("${file.path.root}")
	private String root;
	
	@Value("${file.path.account}")
	private String accountPath;
	
	@Override
	public String findAccountImagePath(int accountId) {
		return mapper.findAccountImagePath(accountId);
	}

	@Override
	public void uploadAccountImage(MultipartFile file, int accountId, AccountImageUploadRequest request) throws IOException {
		fileUtils.saveCroppedImageFile(file, getRootPath(), request);
	}

	private String getRootPath() {
		return root + File.separator + accountPath;
	}
	
}
