package com.wq.system.exception;

public class UserPasswordWrongException extends RuntimeException
{
	public UserPasswordWrongException()
	{
		super();
	}
	public UserPasswordWrongException(String msg)
	{
		super(msg);
	}
	public UserPasswordWrongException(String msg,Throwable e)
	{
		super(msg,e);
	}
}
