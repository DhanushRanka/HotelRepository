package com.hotel.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.service.payload.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ApiResponse handlerResourceNotFoundException( ResourceNotFoundException e)
	{
		String message=e.getMessage();
		ApiResponse ar=new ApiResponse().setMessage(message).setStatus(HttpStatus.NOT_FOUND).setSuccess(false);
		return ar;
	}
	
}
