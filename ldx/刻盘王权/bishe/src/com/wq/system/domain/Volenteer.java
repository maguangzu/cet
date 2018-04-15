package com.wq.system.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wq.Team.domain.Team;
import com.wq.active.domain.Active;

public class Volenteer  implements Serializable 
{
	private Integer volid;
	private Integer teamid;
	private String volidnumber;
	private String voltel;
	private String volname;
	private String password;
	private Integer volshichang;
	private Team Team;
	private Juese juese = new Juese();
	private Set<Quanxian> quanxian = new HashSet<Quanxian>();
	private List<Menu> menus = new ArrayList<Menu>();
	private Set<Active> active=new HashSet<Active>();
	
	
	
	public Juese getJuese() {
		return juese;
	}
	public void setJuese(Juese juese) {
		this.juese = juese;
	}
	public Set<Active> getActive() {
		return active;
	}
	public void setActive(Set<Active> active) {
		this.active = active;
	}
	public Team getTeam() {
		return Team;
	}
	public void setTeam(Team team) {
		Team = team;
	}
	public Integer getVolid()
	{
		return volid;
	}
	public void setVolid(Integer volid)
	{
		this.volid = volid;
	}
	public Integer getTeamid()
	{
		return teamid;
	}
	public void setTeamid(Integer teamid)
	{
		this.teamid = teamid;
	}

	public String getVolidnumber()
	{
		return volidnumber;
	}
	public void setVolidnumber(String volidnumber)
	{
		this.volidnumber = volidnumber;
	}
	public String getVoltel()
	{
		return voltel;
	}
	public void setVoltel(String voltel)
	{
		this.voltel = voltel;
	}
	public String getVolname()
	{
		return volname;
	}
	public void setVolname(String volname)
	{
		this.volname = volname;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public Integer getVolshichang()
	{
		return volshichang;
	}
	public void setVolshichang(Integer volshichang)
	{
		this.volshichang = volshichang;
	}
	
	public Set<Quanxian> getQuanxian()
	{
		return quanxian;
	}
	public void setQuanxian(Set<Quanxian> quanxian)
	{
		this.quanxian = quanxian;
	}
	public List<Menu> getMenus()
	{
		return menus;
	}
	public void setMenus(List<Menu> menus)
	{
		this.menus = menus;
	}
	
	
}
