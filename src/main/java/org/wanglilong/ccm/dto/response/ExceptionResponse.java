package org.wanglilong.ccm.dto.response;

public class ExceptionResponse {

	private String code;
	private String message;
	
	
	public ExceptionResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
