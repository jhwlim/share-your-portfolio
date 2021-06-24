package com.spring.api.domain.account.controller;

import java.io.File;
import java.io.FileInputStream;
import java.security.Principal;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.api.domain.account.dto.AccountImageUploadRequest;
import com.spring.api.domain.account.service.AccountImageService;
import com.spring.api.global.security.model.LoginDetails;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/account/image")
@RestController
public class AccountImageController {
	
	@Value("${file.path.root}")
	private String root;
	
	@Value("${file.path.account")
	private String accountPath;
	
	@Autowired
	private AccountImageService accountImageService;
	
	@GetMapping("/{accountId}")
	public ResponseEntity<byte[]> getAccountImage(@PathVariable int accountId) throws Exception {
		String path = accountImageService.findAccountImagePath(accountId);
		if (path == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		
		String ext = path.substring(path.indexOf(".")+1);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(ext));
		
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(root + File.separator + accountPath + File.separator + path));
		
		return new ResponseEntity<byte[]>(imageBytes, headers, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> uploadAccountImage(MultipartFile file, AccountImageUploadRequest request, @AuthenticationPrincipal LoginDetails loginDetails) {
		log.info("file=" + file.getOriginalFilename());
		log.info("request=" + request);
		log.info("id=" + loginDetails.getId());
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAccountImage() {
		log.info("delete");
		return null;
	}
	
}
