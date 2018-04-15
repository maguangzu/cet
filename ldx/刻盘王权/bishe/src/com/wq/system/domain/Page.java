package com.wq.system.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable
{
	private List<T> list = new ArrayList<T>();
	private int totalPage;
	private int totalNumber;
	private int currentPage;
	public List<T> getList()
	{
		return list;
	}
	public void setList(List<T> list)
	{
		this.list = list;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	public int getTotalNumber()
	{
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber)
	{
		this.totalNumber = totalNumber;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
}
