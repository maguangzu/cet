package cn.cet.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.cet.dao.BaseDao;
import cn.cet.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	
	private BaseDao<T> baseDao;
	
    /*
     * 子类调用父类的set方法完成自动转配
     */
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		baseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		baseDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		baseDao.delete(id);
	}

	@Override
	public T findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.findObjectById(id);
	}

	@Override
	public List<T> findObjects() {
		// TODO Auto-generated method stub
		return baseDao.findObjects();
	}



}
