package cn.cet.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 报名信息
 * @author sk2ln
 *
 */
public class Candidate implements Serializable{
	
	private String id ;
	
	private String admissionCard;//准考证号
	
	private String name;//姓名
	
	private String idcard;//生份证号
	
	private String sex;//性别
	
	private String phone;//电话
	
	private String commAdress;//通讯地址
	
	private String cetType;//报考类型
	
	private String personImg;//个人照片
	
	private Date createTime;
	
	private User user;
	
	public Candidate() {
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	

	public String getAdmissionCard() {
		return admissionCard;
	}


	public void setAdmissionCard(String admissionCard) {
		this.admissionCard = admissionCard;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIdcard() {
		return idcard;
	}


	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCommAdress() {
		return commAdress;
	}


	public void setCommAdress(String commAdress) {
		this.commAdress = commAdress;
	}


	public String getPersonImg() {
		return personImg;
	}


	public void setPersonImg(String personImg) {
		this.personImg = personImg;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getCetType() {
		return cetType;
	}


	public void setCetType(String cetType) {
		this.cetType = cetType;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}
