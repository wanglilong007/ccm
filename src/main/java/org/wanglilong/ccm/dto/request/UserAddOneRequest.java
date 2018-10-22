package org.wanglilong.ccm.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.wanglilong.ccm.dto.BaseRequestDTO;

public class UserAddOneRequest extends BaseRequestDTO {
	
	@NotNull
	@Size(max=20,min=3)
	private String name;
	
	@NotNull
	@Size(max=20,min=6)
	private String password;
	
	private String phone;
	
	@Email
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
