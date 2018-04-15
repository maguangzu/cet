package com.wq.active.domain;

import java.io.Serializable;

public class Active implements Serializable
{
	private Integer activeid;//活动id
	private Integer teamid;//团队id
	private String  activename;//活动名称
	private String begintime;//开始时间
	private String endtime;//结束时间
	private Integer activeshichang;//活动累积时长
	private Integer activeuser;//活动创建者id
	private Integer activevolnum;//活动人数
	private String activeaddrees;//活动地址
	private String activemajor;//活动介绍
	private String activeshuxing;//活动属性
	private int activezhtai;//活动的状态 0申请1通过2结束
	public int getActivezhtai() {
		return activezhtai;
	}
	public void setActivezhtai(int activezhtai) {
		this.activezhtai = activezhtai;
	}
	public Integer getActiveid()
	{
		return activeid;
	}
	public void setActiveid(Integer activeid)
	{
		this.activeid = activeid;
	}
	public Integer getTeamid()
	{
		return teamid;
	}
	public void setTeamid(Integer teamid)
	{
		this.teamid = teamid;
	}
	public String getActivename()
	{
		return activename;
	}
	public void setActivename(String activename)
	{
		this.activename = activename;
	}
	public String getBegintime()
	{
		return begintime;
	}
	public void setBegintime(String begintime)
	{
		this.begintime = begintime;
	}
	public String getEndtime()
	{
		return endtime;
	}
	public void setEndtime(String endtime)
	{
		this.endtime = endtime;
	}
	public Integer getActiveshichang()
	{
		return activeshichang;
	}
	public void setActiveshichang(Integer activeshichang)
	{
		this.activeshichang = activeshichang;
	}
	public Integer getActiveuser()
	{
		return activeuser;
	}
	public void setActiveuser(Integer activeuser)
	{
		this.activeuser = activeuser;
	}
	public Integer getActivevolnum()
	{
		return activevolnum;
	}
	public void setActivevolnum(Integer activeusernum)
	{
		this.activevolnum = activeusernum;
	}
	public String getActiveaddrees()
	{
		return activeaddrees;
	}
	public void setActiveaddrees(String activeaddrees)
	{
		this.activeaddrees = activeaddrees;
	}
	public String getActivemajor()
	{
		return activemajor;
	}
	public void setActivemajor(String activemajor)
	{
		this.activemajor = activemajor;
	}
	public String getActiveshuxing()
	{
		return activeshuxing;
	}
	public void setActiveshuxing(String activeshuxing)
	{
		this.activeshuxing = activeshuxing;
	}
}
