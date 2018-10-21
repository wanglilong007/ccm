package org.wanglilong.ccm;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wanglilong.ccm.dao.api.UserDao;
import org.wanglilong.ccm.dto.request.UserAddOneRequest;
import org.wanglilong.ccm.po.User;
import org.wanglilong.ccm.service.api.IUserService;

@Component
public class CommandRunner implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("wanglilong");
		user.setPassword("123");
		List<User> users = userDao.findAll(user);
		if (users.size()>0){
			return;
		}
		UserAddOneRequest userAddOneReq = new UserAddOneRequest();
		BeanUtils.copyProperties(user, userAddOneReq);
		userService.addOne(userAddOneReq);
	}

}
