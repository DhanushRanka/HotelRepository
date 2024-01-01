package com.hotel.service.payload;

import org.springframework.http.HttpStatus;


public class ApiResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;
	public String getMessage() {
		return message;
	}
	public ApiResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	public boolean isSuccess() {
		return success;
	}
	public ApiResponse setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public ApiResponse setStatus(HttpStatus status) {
		this.status = status;
		return this;
	}
	public ApiResponse(String message, boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
	}
	public ApiResponse() {
		super();
	}

}
