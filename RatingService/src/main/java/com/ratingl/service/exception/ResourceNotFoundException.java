package com.ratingl.service.exception;

import java.util.function.Supplier;

public class ResourceNotFoundException extends Exception {

	public ResourceNotFoundException()
	{
		super("Resource not found exception");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}
