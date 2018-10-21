package org.wanglilong.ccm.dto.response;

import org.wanglilong.ccm.dto.BaseResponseDTO;

public class CreditCardResponse extends BaseResponseDTO {

	private String bankId;
	private String number;
	private Integer statementDate;
	private Integer paymentDate;
	private Integer creditLimit;
	private Integer availableLimit;
	
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
	public Integer getAvailableLimit() {
		return availableLimit;
	}
	public void setAvailableLimit(Integer availableLimit) {
		this.availableLimit = availableLimit;
	}
	
}
