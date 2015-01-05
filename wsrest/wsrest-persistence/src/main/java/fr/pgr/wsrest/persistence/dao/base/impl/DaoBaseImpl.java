package fr.pgr.wsrest.persistence.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import fr.pgr.wsrest.common.om.base.OMBase;
import fr.pgr.wsrest.persistence.dao.base.DaoBase;

public class DaoBaseImpl<T extends OMBase> extends HibernateDaoSupport
		implements DaoBase<T> {

	public void delete(T entity) {
		delete(entity.getIdentifier());
	}

	public void delete(Integer identifier) {
		if (identifier != null) {
			// checks if it exists
			T object = load(identifier);
			if (object != null) {
				this.getHibernateTemplate().delete(object);
			}
		}
	}

	public final List<T> executeListCriteria(final DetachedCriteria requete) {
		return (ArrayList<T>) getHibernateTemplate().findByCriteria(requete);
	}

	public final T executeObjectCriteria(final DetachedCriteria requete) {
		List<T> liste = (List<T>) getHibernateTemplate()
				.findByCriteria(requete);
		if (liste.size() == 0) {
			return null;
		}
		return liste.get(0);
	}

	public T get(Class<T> entityClass, Serializable id) {
		final Object result = this.getHibernateTemplate().get(entityClass, id);
		return (T) result;
	}

	public Class<T> getOMClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	public List<T> list() {
		return (List<T>) this.getHibernateTemplate().loadAll(getOMClass());
	}

	public T load(Class<T> entityClass, Serializable identifier) {
		final Object result = this.getHibernateTemplate().load(entityClass,
				identifier, null);
		return (T) result;
	}

	public T load(Serializable id) {
		final Object result = this.getHibernateTemplate().get(getOMClass(), id);
		return (T) result;
	}

	public T save(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}
}
