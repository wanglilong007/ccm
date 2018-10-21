package org.wanglilong.ccm.dto.request;

import org.wanglilong.ccm.dto.BaseRequestDTO;

public class CreditCardUpdateOneRequest extends BaseRequestDTO{
	private Integer statementDate;
	private Integer paymentDate;
	private Integer creditLimit;
	
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
	public Integer getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}

}
