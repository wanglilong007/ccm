package org.wanglilong.ccm.dto.request;

import org.wanglilong.ccm.dto.BaseRequestDTO;

public class CreditCardAddOneRequest extends BaseRequestDTO{
	private String bankId;
	private String number;
	private Integer statementDate;
	private Integer paymentDate;
	private Integer creditLimit;
	
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
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
