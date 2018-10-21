package org.wanglilong.ccm.service.api;

import java.util.List;

import org.wanglilong.ccm.dto.request.TransactionAddOneRequest;
import org.wanglilong.ccm.dto.request.TransactionUpdateOneRequest;
import org.wanglilong.ccm.dto.response.TransactionResponse;
import org.wanglilong.ccm.exception.NotFoundException;

public interface ITransactionService {
	public String addOne(String creditCardId, TransactionAddOneRequest transactionAddOneRequest);
	public TransactionResponse findOne(String creditCardId, String id) throws NotFoundException;
	public int deleteOne(String creditCardId, String id);
	public int updateOne(String creditCardId, String id, TransactionUpdateOneRequest transactionUpdateOneRequest);
	
	public List<TransactionResponse> findAll(String creditCardId);
}
