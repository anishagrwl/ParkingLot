package com.parkinglot.carsinfo.exception;

public class InternalServerErrorException extends Exception 
{
	public InternalServerErrorException(final String errorMessage)
	{
		super(errorMessage);
	}
	
	public InternalServerErrorException(final String errorMsg, final Throwable errorObject) 
	{
		super(errorMsg, errorObject);
	}
	private static final long serialVersionUID = 1L;
}