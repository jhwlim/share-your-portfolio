package com.spring.api.domain.account.dto;

import com.spring.api.global.util.CropRequest;

import lombok.Builder;

public class AccountImageUploadRequest extends CropRequest {
	
	private static final int SIZE = 300;

	@Builder
	public AccountImageUploadRequest(int left, int top, int width, int height) {
		super(left, top, width, height, SIZE);
	}

}
