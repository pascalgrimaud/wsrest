package fr.pgr.wsrest.persistence.dao;

import fr.pgr.wsrest.common.om.User;
import fr.pgr.wsrest.persistence.dao.base.DaoBase;

public interface UserDao extends DaoBase<User> {
	User loadByUserName(String username);
}