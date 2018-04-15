package cn.cet.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.cet.dao.BaseDao;

//注意：hibernate 4 采用如下方式获取session;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	private Class<T> clazz;
	
	/**
	 * 继承HibernateDaoSupport类必须添加装载sessionFactory
	 */
	@Autowired  
    public void setSessionFactoryOverride(SessionFactory sessionFactory)  
    {  
  
        super.setSessionFactory(sessionFactory);  
    }  
	
	public BaseDaoImpl(){
		//通过反射得到T的真实类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
		getSessionFactory().getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(findObjectById(id));
	}

	@Override
	public T findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) getSessionFactory().getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> findObjects() {
		// TODO Auto-generated method stub
		Query query =  getSessionFactory().getCurrentSession().createQuery("from "+this.clazz.getSimpleName());
		return query.list();
	}
	
	

}
