package cn.cet.dao.impl;


import java.io.Serializable;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.cet.dao.UserDao;
import cn.cet.entity.User;
import cn.cet.web.util.PageBean;



@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	

	public List<User> findObjectByAccAndPwd(String account, String password) {
		System.out.println("account="+account+":password="+password);
		Query query = getSessionFactory().getCurrentSession().createQuery("from User where account = ? and password = ?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		return query.list();
	}

	
	@Override
	public PageBean<User> pageLists(int currentPage, int pageSize) {
		
		String hql = "from User ";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		Query query2 = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<User> list =query.list();
		
		int totalSize=query2.list().size();
		int totalPage=0;
		if(totalSize==0) {
			totalPage=1;
		}else{
			totalPage=(totalSize-1)/pageSize + 1;
		}
		
		
		PageBean<User> pg=new PageBean<User>();
		
		pg.setItems(list);
		
		pg.setPageNo(currentPage);
		
		pg.setTotalSize(totalSize);
		
		pg.setTotalPage(totalPage);
		
		return pg;
		
	}

	

}
