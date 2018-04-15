package com.wq.system.persist;

import java.util.Set;

import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;

public interface VolenteerinfoDao
{
	public Volenteer findvolInfoByvolName(String volname);//登录时用的查找方法,查找用户的所有信息包括基本属性和角色权限
//查找类
	public Page<Volenteer> findAllvols(Volenteer vol, int currentPage);//
	public Volenteer findvolByvolName(String volName);	
	public Volenteer findvolByvolId(Integer volId);
	
	
//更新  
	public void updateRole(Volenteer v);
	
//增加用户	
	public void insertvolInfo(Volenteer v);
	
//删除10.28..............................
	public void deletevolByvolName(String volname);
}
