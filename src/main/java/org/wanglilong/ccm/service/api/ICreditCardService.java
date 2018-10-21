package org.wanglilong.ccm.service.api;

import java.util.List;

import org.wanglilong.ccm.dto.request.CreditCardAddOneRequest;
import org.wanglilong.ccm.dto.request.CreditCardUpdataOneRequest;
import org.wanglilong.ccm.dto.response.CreditCardResponse;
import org.wanglilong.ccm.exception.NotFoundException;

public interface ICreditCardService {

	public String addOne(CreditCardAddOneRequest creditCardAddOneRequest);
	public CreditCardResponse findOne(String id) throws NotFoundException;
	public int deleteOne(String id);
	public int updateOne(String id, CreditCardUpdataOneRequest creditCardUpdataOneRequest);
	public List<CreditCardResponse> findAll(String bankId, String number);
	
}
