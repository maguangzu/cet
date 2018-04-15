package com.wq.active.service;

import java.util.Set;

import com.wq.active.domain.Active;
import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;

public interface activeServiceDao 
{

	public void addactiveInfo(Active at,Volenteer vol);//发起活动

	public Page<Active> findAllactive(Active at, int currentPage);//查询所有活动
	
	public Page<Active> findMyActive(int volid,int currentPage);//查询自己创建的活动

	public Page<Active> findallshactive(int volid, int page);//查询所有审核通过的活动
     
	
}
