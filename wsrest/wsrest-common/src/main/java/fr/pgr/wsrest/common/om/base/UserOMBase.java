package fr.pgr.wsrest.common.om.base;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import fr.pgr.wsrest.common.om.User;

@MappedSuperclass
public class UserOMBase extends OMBase {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5082456437884845907L;
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
