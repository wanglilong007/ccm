package org.wanglilong.ccm.dto.request;

import org.wanglilong.ccm.dto.BaseDTO;

public class UserUpdateOneRequest extends BaseDTO {
	private String password;
	private String phone;
	private String email;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
