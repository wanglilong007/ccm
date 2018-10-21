package org.wanglilong.ccm.dto.request;

import org.wanglilong.ccm.dto.BaseDTO;

public class CreditCardUpdataOneRequest extends BaseDTO{
	private Integer statementDate;
	private Integer paymentDate;
	public Integer getStatementDate() {
		return statementDate;
	}
	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}
	public Integer getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Integer paymentDate) {
		this.paymentDate = paymentDate;
	}

	
}
