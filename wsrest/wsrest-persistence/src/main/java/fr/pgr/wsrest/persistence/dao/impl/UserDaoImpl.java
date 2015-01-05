package fr.pgr.wsrest.persistence.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import fr.pgr.wsrest.common.om.User;
import fr.pgr.wsrest.persistence.dao.UserDao;
import fr.pgr.wsrest.persistence.dao.base.impl.DaoBaseImpl;

public class UserDaoImpl extends DaoBaseImpl<User> implements UserDao {

	public User loadByUserName(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getOMClass());
		criteria.add(Restrictions.eq("login", username));
		return executeObjectCriteria(criteria);
	}
}