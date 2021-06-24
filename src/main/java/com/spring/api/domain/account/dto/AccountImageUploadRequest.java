package com.spring.api.domain.account.dto;

import com.spring.api.global.util.file.CropRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class AccountImageUploadRequest extends CropRequest {
	
	private static final int SIZE = 300;

	private int left;
	private int top;
	private int width;
	private int height;

	@Builder
	public AccountImageUploadRequest(int left, int top, int width, int height) {
		super(left, top, width, height, SIZE);
	}

	
}
