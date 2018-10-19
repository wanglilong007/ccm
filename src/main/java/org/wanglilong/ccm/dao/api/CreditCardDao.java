package org.wanglilong.ccm.dao.api;

import org.wanglilong.ccm.po.CreditCard;

public interface CreditCardDao {

	public int addOne(CreditCard creditCard);
	public CreditCard findOne(String id);
	public int deleteOne(String id);
	public int updateOne(CreditCard creditCard);
}
