package org.wanglilong.ccm.service.api;

import org.wanglilong.ccm.po.Transaction;

public interface ITransactionService {
	public String addOne(Transaction transaction);
	public Transaction findOne(Transaction transaction);
	public int deleteOne(Transaction transaction);
	public int updateOne(Transaction transaction);
}
