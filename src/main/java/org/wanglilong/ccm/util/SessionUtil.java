package org.wanglilong.ccm.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.wanglilong.ccm.po.BasePO;
import org.wanglilong.ccm.security.SessionUser;

public class SessionUtil {

	public static void addCurrentUser(BasePO basePO){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof SessionUser) {
			SessionUser user = (SessionUser) principal;
			basePO.setCreator(user.getId());
		}
	}
	
	public static SessionUser getCurrentUser(){
		SessionUser user = new SessionUser();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof SessionUser) {
			user = (SessionUser) principal;
		}
		return user;
	}
}
