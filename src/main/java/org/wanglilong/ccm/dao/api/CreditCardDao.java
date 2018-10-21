package org.wanglilong.ccm.dao.api;

import java.util.List;

import org.wanglilong.ccm.po.CreditCard;

public interface CreditCardDao {

	public int addOne(CreditCard creditCard);
	public CreditCard findOne(CreditCard creditCard);
	public List<CreditCard> findAll(CreditCard creditCard);
	public int deleteOne(CreditCard creditCard);
	public int deleteAll();
	public int updateOne(CreditCard creditCard);
}
