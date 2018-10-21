package org.wanglilong.ccm.dao.api;

import java.util.List;

import org.wanglilong.ccm.po.Transaction;
import org.wanglilong.ccm.po.User;

public interface TransactionDao {
	public int addOne(Transaction transaction);
	public Transaction findOne(Transaction transaction);
	public int deleteOne(Transaction transaction);
	public int updateOne(Transaction transaction);
	
	public List<User> findAll(Transaction transaction);
	public int deleteAll();
}
