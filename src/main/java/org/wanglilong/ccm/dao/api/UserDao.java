package org.wanglilong.ccm.dao.api;

import java.util.List;

import org.wanglilong.ccm.po.User;

public interface UserDao {
	public int addOne(User user);
	public User findOne(User user);
	public int deleteOne(User user);
	public int updateOne(User user);
	
	public List<User> findAll(User user);
	public int deleteAll();
}
