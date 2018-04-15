package com.wq.active.persist;

import java.util.Set;

import com.wq.active.domain.Active;
import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;

public interface ActiveinfaoDao 
{

	

	public Set<Active> findactiveByvolname(String volName);//通过用户名查找活动

	public void addActiveInfo(Active at,Volenteer vol);//添加活动

	public Page<Active> findAllats(Active at, int currentPage) ;//查找所有的活动

	public Page<Active> findmyactive(int volid,int currentPage);//查找自己创建的活动

	public Page<Active> findallshactive(int volid, int page);
	

	

}
