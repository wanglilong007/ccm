package org.wanglilong.ccm.dto.request;

import java.util.Date;

import org.wanglilong.ccm.dto.BaseRequestDTO;

public class TransactionAddOneRequest extends BaseRequestDTO {
	
	private Integer amount;
	private Date time;
	private String merchant;
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	
	
}
