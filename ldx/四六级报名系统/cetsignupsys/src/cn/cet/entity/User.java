package cn.cet.entity;

import java.io.Serializable;

/**
 * 系统用户信息
 * @author sk2ln
 *
 */
public class User implements Serializable{
	
	private String id ;
	private String account;//账号
	private String password;//密码
	private String mobile;//电话
	private String email;//邮箱
	private boolean role;	//是否超级管理员,false为学生
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
}
