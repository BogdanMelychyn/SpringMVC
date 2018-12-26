package homeProject.service.impl;

import java.util.List;

import homeProject.dao.BasicDao;
import homeProject.service.BasicService;

public abstract class BasicServiceImpl<T> implements BasicService<T> {
		
	public List<T> findAll() {
		return getMainDao().findAll();
	}

	public void insert(T entity) {
		getMainDao().insert(entity);
		
		
	}

	public T findById(Object id) {
		return getMainDao().findById(id);
	}

	public void delById(Object id) {
		getMainDao().delById(id);
		
	}

	public T update(T entity) {
		return getMainDao().update(entity);
	}

	public List<T> findByProperty(String property, Object value) {
		return getMainDao().findByProperty(property, value);
	}

	public abstract BasicDao<T> getMainDao();
}
