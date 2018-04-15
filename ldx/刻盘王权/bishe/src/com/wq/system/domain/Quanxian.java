package com.wq.system.domain;

import java.io.Serializable;

public class Quanxian implements Serializable
{
	private Integer quanxianid;
	private String quanxianname;
	private String quanxianurl;
	public Integer getQuanxianid()
	{
		return quanxianid;
	}
	public void setQuanxianid(Integer quanxianid)
	{
		this.quanxianid = quanxianid;
	}
	public String getQuanxianname()
	{
		return quanxianname;
	}
	public void setQuanxianname(String quanxianname)
	{
		this.quanxianname = quanxianname;
	}
	public String getQuanxianurl()
	{
		return quanxianurl;
	}
	public void setQuanxianurl(String quanxianurl)
	{
		this.quanxianurl = quanxianurl;
	}
}
