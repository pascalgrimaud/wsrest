package fr.pgr.wsrest.service.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.pgr.wsrest.common.om.User;
import fr.pgr.wsrest.persistence.dao.UserDao;
import fr.pgr.wsrest.service.UserService;
import fr.pgr.wsrest.service.base.impl.ServiceBaseImpl;

public class UserServiceImpl extends ServiceBaseImpl<User> implements
		UserService, UserDetailsService {

	/**
	 * dao
	 */
	private UserDao dao;

	/**
	 * l'encodeur de mot de passe injecte par spring
	 */
	private PasswordEncoder passEncoder;

	/**
	 * Objet qui permet de faire un "salt" sur le mot de passe avant de <br/>
	 * le hasher. Cela ajout un niveau de sécurité en rendant plus difficiles
	 * les attaque<br/>
	 * par dictionnaire.
	 */
	private SaltSource saltSource;

	/**
	 * 
	 * @return the dao
	 */
	public UserDao getDao() {
		return dao;
	}

	/**
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		return dao.loadByUserName(arg0);
	}

	public void setPassEncoder(PasswordEncoder passEncoder) {
		this.passEncoder = passEncoder;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}
}