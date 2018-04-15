package cn.cet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cet.dao.UserDao;
import cn.cet.entity.User;
import cn.cet.service.BaseService;
import cn.cet.service.UserService;
import cn.cet.web.util.PageBean;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	private UserDao userDao;
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao=userDao;
	}

	
	
	public User login(String account, String password) {
		List<User> list = userDao.findObjectByAccAndPwd(account,password);
		System.out.println("list="+list);
		if(list.size()>0){
			return list.remove(0);
		}
		return null;
	}



	@Override
	public PageBean<User> pageLists(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.pageLists(currentPage, pageSize);
	}
	

}
