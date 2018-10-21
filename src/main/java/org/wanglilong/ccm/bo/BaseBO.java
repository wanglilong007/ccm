package org.wanglilong.ccm.bo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.wanglilong.ccm.security.SessionUser;

public class BaseBO {

	private SessionUser currentUser;

	public BaseBO() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof SessionUser) {
			setCurrentUser((SessionUser) principal);
		}
	}

	public SessionUser getCurrentUser() {
		return currentUser;
	}

	private void setCurrentUser(SessionUser currentUser) {
		this.currentUser = currentUser;
	}
	
}
