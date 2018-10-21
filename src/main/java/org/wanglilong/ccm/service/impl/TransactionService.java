package org.wanglilong.ccm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wanglilong.ccm.dao.api.TransactionDao;
import org.wanglilong.ccm.dto.request.TransactionAddOneRequest;
import org.wanglilong.ccm.dto.request.TransactionUpdateOneRequest;
import org.wanglilong.ccm.dto.response.TransactionResponse;
import org.wanglilong.ccm.exception.NotFoundException;
import org.wanglilong.ccm.po.Transaction;
import org.wanglilong.ccm.service.api.ITransactionService;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	public String addOne(String creditCardId, TransactionAddOneRequest transactionAddOneRequest) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionAddOneRequest, transaction);
		String uuid = UUID.randomUUID().toString();
		transaction.setId(uuid);
		transaction.setCreditCardId(creditCardId);
		transactionDao.addOne(transaction);
		return uuid;
	}

	@Override
	public TransactionResponse findOne(String creditCardId, String id) throws NotFoundException {
		Transaction transaction = new Transaction();
		transaction.setCreditCardId(creditCardId);
		transaction.setId(id);
		Transaction trans = transactionDao.findOne(transaction);
		TransactionResponse transactionResponse = null;
		if (trans != null) {
			transactionResponse = new TransactionResponse();
			BeanUtils.copyProperties(trans, transactionResponse);
		} else {
			throw new NotFoundException(String.format("can not found transaction with id %s", id));
		}
		return transactionResponse;
	}

	@Override
	public int deleteOne(String creditCardId, String id) {
		Transaction transaction = new Transaction();
		transaction.setCreditCardId(creditCardId);
		transaction.setId(id);
		int ret = transactionDao.deleteOne(transaction);
		return ret;
	}

	@Override
	public int updateOne(String creditCardId, String id, TransactionUpdateOneRequest transactionUpdateOneRequest) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionUpdateOneRequest, transaction);
		transaction.setCreditCardId(creditCardId);
		transaction.setId(id);
		int ret = transactionDao.updateOne(transaction);
		return ret;
	}

	@Override
	public List<TransactionResponse> findAll(String creditCardId) {
		Transaction transaction = new Transaction();
		transaction.setCreditCardId(creditCardId);
		List<Transaction> transactions = transactionDao.findAll(transaction);
		List<TransactionResponse> creditCardResponses = new ArrayList<TransactionResponse>();
		for (Iterator iterator = transactions.iterator(); iterator.hasNext();) {
			Transaction transaction1 = (Transaction) iterator.next();
			TransactionResponse transactionResponse = new TransactionResponse();
			BeanUtils.copyProperties(transaction1, transactionResponse);
			creditCardResponses.add(transactionResponse);
		}
		return creditCardResponses;
	}

}
