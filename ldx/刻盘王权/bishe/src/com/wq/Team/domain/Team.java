package com.wq.Team.domain;

import java.io.Serializable;

public class Team implements Serializable
{
	private Integer teamid;//团队编号
	private String  teamname;//团队名称
	private Integer  teamusernum;//团队人数
	private String   teamusername;//团队创建者用户名
	private String   teammadetime;//团队创建时间
	private String   teamdesc;//团队介绍
	private String   teamjs;//团队学校
	private String   teamzhtai;//状态 审核 活动中 解散
	private String   teamdeltime;//解散时间
	private String[]   teamshuxing;//属性
	public String getTeamdesc() {
		return teamdesc;
	}
	public void setTeamdesc(String teamdesc) {
		this.teamdesc = teamdesc;
	}
	public String getTeamjs() {
		return teamjs;
	}
	public void setTeamjs(String teamjs) {
		this.teamjs = teamjs;
	}
	public String getTeamzhtai() {
		return teamzhtai;
	}
	public void setTeamzhtai(String teamzhtai) {
		this.teamzhtai = teamzhtai;
	}
	public Integer getTeamid()
	{
		return teamid;
	}
	public void setTeamid(Integer teamid)
	{
		this.teamid = teamid;
	}
	public String getTeamname()
	{
		return teamname;
	}
	public void setTeamname(String teamname)
	{
		this.teamname = teamname;
	}
	public Integer getTeamusernum()
	{
		return teamusernum;
	}
	public void setTeamusernum(Integer teamusernum)
	{
		this.teamusernum = teamusernum;
	}
	public String getTeamusername()
	{
		return teamusername;
	}
	public void setTeamusername(String teamusername)
	{
		this.teamusername = teamusername;
	}
	public String getTeammadetime()
	{
		return teammadetime;
	}
	public void setTeammadetime(String teammadetime)
	{
		this.teammadetime = teammadetime;
	}
	public String getTeamdeltime()
	{
		return teamdeltime;
	}
	public void setTeamdeltime(String teamdeltime)
	{
		this.teamdeltime = teamdeltime;
	}

	public String[] getTeamshuxing() {
		return teamshuxing;
	}
	public void setTeamshuxing(String[] teamshuxing) {
		this.teamshuxing = teamshuxing;
	}

	
	
	
}
