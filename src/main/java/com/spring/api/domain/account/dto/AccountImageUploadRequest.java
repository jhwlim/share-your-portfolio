package com.spring.api.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class AccountImageUploadRequest {
	
	public final static int SIZE = 300;
	
	private int left;
	private int top;
	private int width;
	private int height;

	@Builder
	public AccountImageUploadRequest(int left, int top, int width, int height) {
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
	}
	
}
