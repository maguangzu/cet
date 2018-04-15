package com.wq.system.service;

import com.wq.Team.domain.Team;
import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;

public interface SystemService
{
	public Volenteer login(String volName,String volPwd);//用户登录
	public Page<Volenteer> findAllvols(Volenteer vol,int currentPage);//查找所有志愿者信息	
	public void addvolInfo(Volenteer vol);//注册新志愿者
	public void deletevol(String volname);//删除志愿者信息
	public void createActive(String acttive);//创建活动审核
	public void delActive(String acttive);//终止活动
	public void createteam(Team team);//创建新的团队审核
	public void delTeam(Team team);//解散团队
}
