package org.wanglilong.ccm.dao.api;

import java.util.List;

import org.wanglilong.ccm.po.Transaction;

public interface TransactionDao {
	public int addOne(Transaction transaction);
	public Transaction findOne(Transaction transaction);
	public int deleteOne(Transaction transaction);
	public int updateOne(Transaction transaction);
	
	public List<Transaction> findAll(Transaction transaction);
	public int deleteAll();
}
