package org.wanglilong.ccm.dto.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

import org.wanglilong.ccm.dto.BaseRequestDTO;

public class TransactionAddOneRequest extends BaseRequestDTO {
	
	@Min(value = 0)
	private Integer amount;
	
	@PastOrPresent
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
