package cn.cet.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(Serializable id);
	
	public T findObjectById(Serializable id);
	
	public List<T> findObjects();

}
