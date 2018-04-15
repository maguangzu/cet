package com.wq.system.domain;

import java.io.Serializable;

public class Shuxing implements Serializable
{
	private String shuxingName;
	private Integer shuxingid;
	public String getShuxingName()
	{
		return shuxingName;
	}
	public void setShuxingName(String shuxingName)
	{
		this.shuxingName = shuxingName;
	}
	public Integer getShuxingid()
	{
		return shuxingid;
	}
	public void setShuxingid(Integer shuxingid)
	{
		this.shuxingid = shuxingid;
	}
}
