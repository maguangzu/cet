package com.wq.system.exception;

public class UserNotFoundException extends RuntimeException
{
	public UserNotFoundException()
	{
		super();
	}
	public UserNotFoundException(String msg)
	{
		super(msg);
	}
	public UserNotFoundException(String msg,Throwable e)
	{
		super(msg,e);
	}
}
