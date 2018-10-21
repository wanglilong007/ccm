package org.wanglilong.ccm.service.api;

import java.util.List;

import org.wanglilong.ccm.dto.request.UserAddOneRequest;
import org.wanglilong.ccm.dto.request.UserUpdateOneRequest;
import org.wanglilong.ccm.dto.response.UserResponse;
import org.wanglilong.ccm.exception.NotFoundException;

public interface IUserService {
	public String addOne(UserAddOneRequest userAddOneRequest);
	public UserResponse findOne(String id) throws NotFoundException;
	public int deleteOne(String id);
	
	public int updateOne(String id, UserUpdateOneRequest userUpdateOneRequest);
	public List<UserResponse> findAll(String name, String phone, String email);
}
