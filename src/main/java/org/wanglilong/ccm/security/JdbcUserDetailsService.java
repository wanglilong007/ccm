package org.wanglilong.ccm.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wanglilong.ccm.dao.api.UserDao;
import org.wanglilong.ccm.po.User;

@Service
public class JdbcUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		SessionUser sessionUser = new SessionUser();
		User user = new User();
		user.setName(name);
		List<User> users = userDao.findAll(user);
		user = users.get(0);
		if (users.size() > 0){
			sessionUser.setId(user.getId());
			sessionUser.setName(user.getName());
			sessionUser.setPassword(user.getPassword());
			sessionUser.setPhone(user.getPhone());
			sessionUser.setEmail(user.getEmail());
		}else{
			throw new UsernameNotFoundException(String.format("%s not found", name));
		}
		return sessionUser;
	}

}
