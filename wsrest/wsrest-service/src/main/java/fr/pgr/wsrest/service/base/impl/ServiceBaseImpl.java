package fr.pgr.wsrest.service.base.impl;

import java.io.Serializable;
import java.util.List;

import fr.pgr.wsrest.common.om.base.OMBase;
import fr.pgr.wsrest.persistence.dao.base.DaoBase;
import fr.pgr.wsrest.service.base.ServiceBase;

public abstract class ServiceBaseImpl<T extends OMBase> implements
		ServiceBase<T> {

	public abstract DaoBase<T> getDao();

	@Override
	public void delete(Integer identifier) {
		getDao().delete(identifier);

	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public T get(Class<T> entityClass, Serializable id) {
		return getDao().get(entityClass, id);
	}

	@Override
	public List<T> list() {
		return getDao().list();
	}

	@Override
	public T load(Class<T> entityClass, Serializable identifiant) {
		return getDao().load(entityClass, identifiant);
	}

	@Override
	public T load(Serializable id) {
		return getDao().load(id);
	}

	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}
}