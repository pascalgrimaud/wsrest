package fr.pgr.wsrest.service.base;

import java.io.Serializable;
import java.util.List;

import fr.pgr.wsrest.common.om.base.IOM;
import fr.pgr.wsrest.persistence.dao.base.DaoBase;

public interface ServiceBase<T extends IOM> {
	DaoBase<T> getDao();

	T load(Class<T> entityClass, Serializable identifiant);

	/**
	 * 
	 * @param entityClass
	 *            entityClass.
	 * @param id
	 *            identifiant.
	 * @return Class<T>.
	 */
	T get(Class<T> entityClass, Serializable id);

	/**
	 * loads an object from its id. Returns null if no object was found
	 * 
	 * @param id
	 *            identifier
	 * 
	 * @return Class<T>.
	 */
	T load(Serializable id);

	/**
	 * @return List<T>.
	 */
	List<T> list();

	/**
	 * @param entity
	 *            objet.
	 */
	void delete(T entity);

	/**
	 * Deletion by identifier
	 * 
	 * @param identifier
	 *            the identifier of the object to delete
	 */
	void delete(Integer identifier);

	/**
	 * @param entity
	 *            objet.
	 * @return the object
	 */
	T save(final T entity);
}
