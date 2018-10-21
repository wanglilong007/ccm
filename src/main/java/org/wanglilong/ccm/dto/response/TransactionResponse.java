package org.wanglilong.ccm.dto.response;

import java.util.Date;

import org.wanglilong.ccm.dto.BaseResponseDTO;

public class TransactionResponse extends BaseResponseDTO {

	private String creditCardId;
	private Integer amount;
	private Date time;
	private String merchant;
	public String getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(String creditCardId) {
		this.creditCardId = creditCardId;
	}
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
