package cn.cet.dao;

import java.io.Serializable;


import java.util.List;

import cn.cet.entity.User;
import cn.cet.web.util.PageBean;



public interface UserDao extends BaseDao<User>{

	/**
	 * 根据帐号和密码查找用户
	 * @param account
	 * @param password
	 * @return
	 */
	List<User> findObjectByAccAndPwd(String account, String password);
	
  
	public PageBean<User> pageLists(int currentPage,int pageSize);

}
