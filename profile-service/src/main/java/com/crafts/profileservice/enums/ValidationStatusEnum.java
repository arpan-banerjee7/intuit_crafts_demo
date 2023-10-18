package com.crafts.profileservice.enums;

import lombok.Getter;

@Getter
public enum ValidationStatusEnum {

	IN_PROGRESS("In Progress"), SUCCESS("Success"), FAILED("Failed");

	private final String status;

	ValidationStatusEnum(String status) {
		this.status = status;
	}

}
