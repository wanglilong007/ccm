package org.wanglilong.ccm.dao.api;

import org.wanglilong.ccm.po.User;

public interface UserDao {
	public int addOne(User user);
	public User findOne(String id);
	public int deleteOne(String id);
	public int updateOne(User user);
}
