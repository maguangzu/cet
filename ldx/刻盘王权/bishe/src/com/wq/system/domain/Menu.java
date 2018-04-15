package com.wq.system.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable
{
	private Integer menuid;
	private String menuname;
	private String menuurl;
	private Integer menmenuid;
	private List<Menu> sons = new ArrayList<Menu>();
	public Integer getMenuid()
	{
		return menuid;
	}
	public void setMenuid(Integer menuid)
	{
		this.menuid = menuid;
	}
	public String getMenuname()
	{
		return menuname;
	}
	public void setMenuname(String menuname)
	{
		this.menuname = menuname;
	}
	public String getMenuurl()
	{
		return menuurl;
	}
	public void setMenuurl(String menuurl)
	{
		this.menuurl = menuurl;
	}
	public Integer getMenmenuid()
	{
		return menmenuid;
	}
	public void setMenmenuid(Integer menmenuid)
	{
		this.menmenuid = menmenuid;
	}
	public List<Menu> getSons()
	{
		return sons;
	}
	public void setSons(List<Menu> sons)
	{
		this.sons = sons;
	}
	
}
