package com.wq.system.persist;

public interface VolJueseDao 
{
	public void deleteByvolName(String volName);//删除用户对应的角色
	public void insertByvolNameAndRoleIds(String volname);//给新用户普通角色属性
 
}
