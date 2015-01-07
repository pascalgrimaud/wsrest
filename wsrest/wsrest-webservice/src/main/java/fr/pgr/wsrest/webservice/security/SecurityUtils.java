package fr.pgr.wsrest.webservice.security;

import org.springframework.security.core.context.SecurityContextHolder;

import fr.pgr.wsrest.common.om.User;

public class SecurityUtils {
	public static User getConnectedUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
