package homeProject.dao;

import java.util.List;

public interface BasicDao<T> {
	List<T> findAll();
	void insert(T entity);
	T findById(Object id);
	void delById(Object id);
	T update(T entity);
	List<T> findByProperty(String property, Object value);
}
