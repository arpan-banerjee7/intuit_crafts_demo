package com.crafts.profileservice.enums;

public enum ValidationStatusEnum {

	IN_PROGRESS("In Progress"), SUCCESS("Success"), FAILED("Failed");

	private String status;

	ValidationStatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
}
