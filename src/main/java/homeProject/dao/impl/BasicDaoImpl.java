package homeProject.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import homeProject.dao.BasicDao;

public abstract class BasicDaoImpl<T> implements BasicDao<T> {
	@PersistenceContext(unitName = "primary")
	protected EntityManager em;
	private Class<?> entityClass;

	public BasicDaoImpl() {
		entityClass = getEntityClass();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("From " + entityClass.getSimpleName())
				.getResultList();
	
	}

	@Transactional
	public void insert(T entity) {
		em.persist(entity);
	}
	@Transactional
	public void delById(Object id) {
		em.remove(em.find(getEntityClass(), id));
		
	}

	public T findById(Object id) {
		return em.find(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	protected final Class<T> getEntityClass() {
		final Type type = getClass().getGenericSuperclass() instanceof ParameterizedType ? getClass()
				.getGenericSuperclass() : getClass().getSuperclass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			final ParameterizedType paramType = (ParameterizedType) type;
			return (Class<T>) paramType.getActualTypeArguments()[0];
		} else
			throw new IllegalArgumentException(
					"Could not guess entity class by reflection");
	}

	
	@Transactional
	public void deleteAll() {
		em.createQuery("DELETE FROM " + entityClass.getSimpleName())
				.executeUpdate();
	}

	@Transactional
	public T update(T entity) {
		return em.merge(entity);
	}


	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property, Object value) {
		return em.createQuery("SELECT a FROM " + entityClass.getSimpleName() + " a WHERE a." + property + " = '"
						+ value + "'").getResultList();
		
	}
	public int count() {
		return ((Number) em.createQuery(
				"SELECT COUNT(c) FROM " + entityClass.getSimpleName() + " c")
				.getSingleResult()).intValue();
	}


}
