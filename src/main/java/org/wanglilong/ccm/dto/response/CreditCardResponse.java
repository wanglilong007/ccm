package org.wanglilong.ccm.dto.response;

import java.util.Date;

import org.wanglilong.ccm.dto.BaseDTO;

public class CreditCardResponse extends BaseDTO {

	private String id;
	private String bankId;
	private String number;
	private Integer statementDate;
	private Integer paymentDate;
	private Date createTime;
	private Date updateTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
