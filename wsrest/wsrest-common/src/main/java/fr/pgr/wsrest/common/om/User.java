package fr.pgr.wsrest.common.om;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.pgr.wsrest.common.om.base.OMBase;

@Entity
@Table(name = "user")
public class User extends OMBase implements UserDetails {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8357535827864380L;
	/**
	 * The login of the user, used for authentication
	 */
	private String login;
	/**
	 * The password of the user, used for authentication
	 */
	private String password;
	/**
	 * The mail address of the user
	 */
	private String mailAddress;
	/**
	 * The creation date of the user
	 */
	private Date creationDate;

	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mail_address")
	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Column(name = "creation_date")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}