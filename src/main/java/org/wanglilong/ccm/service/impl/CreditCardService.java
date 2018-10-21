package org.wanglilong.ccm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wanglilong.ccm.dao.api.CreditCardDao;
import org.wanglilong.ccm.dto.request.CreditCardAddOneRequest;
import org.wanglilong.ccm.dto.request.CreditCardUpdataOneRequest;
import org.wanglilong.ccm.dto.response.CreditCardResponse;
import org.wanglilong.ccm.exception.NotFoundException;
import org.wanglilong.ccm.po.CreditCard;
import org.wanglilong.ccm.service.api.ICreditCardService;

@Service
public class CreditCardService implements ICreditCardService {

	@Autowired
	private CreditCardDao creditCardDao;
	
	@Override
	public String addOne(CreditCardAddOneRequest creditCardAddOneRequest) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardAddOneRequest, creditCard);
		String uuid = UUID.randomUUID().toString();
		creditCard.setId(uuid);
		creditCardDao.addOne(creditCard);
		return uuid;
	}

	@Override
	public CreditCardResponse findOne(String id) throws NotFoundException {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(id);
		CreditCard card = creditCardDao.findOne(creditCard);
		CreditCardResponse creditCardResponse = null;
		if (card != null) {
			creditCardResponse = new CreditCardResponse();
			BeanUtils.copyProperties(card, creditCardResponse);
		} else {
			throw new NotFoundException(String.format("can not found credit card with id %s", id));
		}
		return creditCardResponse;
	}

	@Override
	public int deleteOne(String id) {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(id);
		int ret = creditCardDao.deleteOne(creditCard);
		return ret;
	}

	@Override
	public int updateOne(String id, CreditCardUpdataOneRequest creditCardUpdataOneRequest) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardUpdataOneRequest, creditCard);
		creditCard.setId(id);
		int ret = creditCardDao.updateOne(creditCard);
		return ret;
	}

	@Override
	public List<CreditCardResponse> findAll(String bankId, String number) {
		CreditCard creditCard = new CreditCard();
		creditCard.setBankId(bankId);
		creditCard.setNumber(number);
		List<CreditCard> creditCards = creditCardDao.findAll(creditCard);
		List<CreditCardResponse> creditCardResponses = new ArrayList<CreditCardResponse>();
		for (Iterator iterator = creditCards.iterator(); iterator.hasNext();) {
			CreditCard card = (CreditCard) iterator.next();
			CreditCardResponse creditCardResponse = new CreditCardResponse();
			BeanUtils.copyProperties(card, creditCardResponse);
			creditCardResponses.add(creditCardResponse);
		}
		return creditCardResponses;
	}

}
