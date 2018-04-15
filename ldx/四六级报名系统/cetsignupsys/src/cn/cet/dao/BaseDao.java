package cn.cet.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 抽象的基本接口
 * @author sk2ln
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(Serializable id);
	
	public T findObjectById(Serializable id);
	
	public List<T> findObjects();

}
