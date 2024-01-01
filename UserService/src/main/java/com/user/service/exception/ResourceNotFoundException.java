package com.user.service.exception;

public class ResourceNotFoundException extends Exception{
	
	public ResourceNotFoundException()
	{
		super("Resource not found exception");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
