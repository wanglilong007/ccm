package org.wanglilong.ccm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.wanglilong.ccm.dao.api.UserDao;
import org.wanglilong.ccm.dto.request.UserAddOneRequest;
import org.wanglilong.ccm.dto.request.UserUpdateOneRequest;
import org.wanglilong.ccm.dto.response.UserResponse;
import org.wanglilong.ccm.exception.NotFoundException;
import org.wanglilong.ccm.po.User;
import org.wanglilong.ccm.service.api.IUserService;

@Service
public class UserService implements IUserService {

	private final static Log log = LogFactory.getLog(UserService.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addOne(UserAddOneRequest userAddOneRequest) {
		User user = new User();
		BeanUtils.copyProperties(userAddOneRequest, user);
		String uuid = UUID.randomUUID().toString();
		user.setId(uuid);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreator(uuid);
		userDao.addOne(user);
		return uuid;
	}

	@Override
	public UserResponse findOne(String id) throws NotFoundException {
		User user = new User();
		user.setId(id);
		User userFound = userDao.findOne(user);
		UserResponse userResponse = null;
		if (userFound != null){
			userResponse = new UserResponse();
			BeanUtils.copyProperties(userFound, userResponse);
		} else {
			throw new NotFoundException(String.format("can not found user with id %s", id));
		}
		return userResponse;
	}

	@Override
	public int deleteOne(String id) {
		User user = new User();
		user.setId(id);
		return userDao.deleteOne(user);
	}

	@Override
	public int updateOne(String id, UserUpdateOneRequest userUpdateOneRequest) {
		User user = new User();
		BeanUtils.copyProperties(userUpdateOneRequest, user);
		user.setId(id);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.updateOne(user);
	}

	@Override
	public List<UserResponse> findAll(String name, String phone, String email) {
		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		List<User> users = userDao.findAll(user);

		List<UserResponse> userResponses = new ArrayList<UserResponse>();
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user1 = (User) iterator.next();
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(user1, userResponse);
			userResponses.add(userResponse);
		}
		
		return userResponses;
	}

}
