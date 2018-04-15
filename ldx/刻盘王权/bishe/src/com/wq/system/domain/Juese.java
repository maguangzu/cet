package com.wq.system.domain;

import java.io.Serializable;

public class Juese implements Serializable
{
	private Integer jueseid;
	private String juesename;
	private String jueseurl;
	public Integer getJueseid()
	{
		return jueseid;
	}
	public void setJueseid(Integer jueseid)
	{
		this.jueseid = jueseid;
	}
	public String getJuesename()
	{
		return juesename;
	}
	public void setJuesename(String juesename)
	{
		this.juesename = juesename;
	}
	public String getJueseurl()
	{
		return jueseurl;
	}
	public void setJueseurl(String jueseurl)
	{
		this.jueseurl = jueseurl;
	}
}
