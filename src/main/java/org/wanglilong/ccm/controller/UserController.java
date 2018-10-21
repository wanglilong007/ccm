package org.wanglilong.ccm.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wanglilong.ccm.dto.request.UserAddOneRequest;
import org.wanglilong.ccm.dto.request.UserUpdateOneRequest;
import org.wanglilong.ccm.dto.response.UserResponse;
import org.wanglilong.ccm.exception.NotFoundException;
import org.wanglilong.ccm.security.SessionUser;
import org.wanglilong.ccm.service.api.IUserService;
import org.wanglilong.ccm.util.SessionUtil;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping
	public String addOne(@RequestBody UserAddOneRequest user) {
		return userService.addOne(user);
	}

	@GetMapping("/me")
	public UserResponse me() throws NotFoundException {
		SessionUser sessionUser = SessionUtil.getCurrentUser();
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(sessionUser, userResponse);
		return userResponse;
	}
	
	@GetMapping("/{id}")
	public UserResponse findOne(@PathVariable String id) throws NotFoundException {
		return userService.findOne(id);
	}

	@DeleteMapping("/me")
	public int deleteOne() {
		return userService.deleteOne(SessionUtil.getCurrentUser().getId());
	}

	@PutMapping("/me")
	public int updateOne(@RequestBody UserUpdateOneRequest user) {
		return userService.updateOne(SessionUtil.getCurrentUser().getId(), user);
	}

	@GetMapping
	public List<UserResponse> findAll(@RequestParam(required=false) String name, 
			@RequestParam(required=false) String phone,
			@RequestParam(required=false) String email) {
		return userService.findAll(name, phone, email);
	}
}
