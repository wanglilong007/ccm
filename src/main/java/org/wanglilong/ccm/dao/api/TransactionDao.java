package org.wanglilong.ccm.dao.api;

import org.wanglilong.ccm.po.Transaction;

public interface TransactionDao {
	public int addOne(Transaction transaction);
	public Transaction findOne(String id);
	public int deleteOne(String id);
	public int updateOne(Transaction transaction);
}
