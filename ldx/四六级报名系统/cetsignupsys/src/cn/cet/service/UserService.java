package cn.cet.service;

import java.util.List;


import cn.cet.entity.User;
import cn.cet.web.util.PageBean;

public interface UserService extends BaseService<User>{
	
	
	/**
	 *  普通用户登录方法
	 * @param account
	 * @param password
	 * @return
	 */
	User login(String account, String password);
	
	//分页查询
	public PageBean<User> pageLists(int currentPage,int pageSize);

}
