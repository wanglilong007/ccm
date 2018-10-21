package org.wanglilong.ccm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.wanglilong.ccm.dto.response.ExceptionResponse;
import org.wanglilong.ccm.exception.NotFoundException;

@ControllerAdvice
public class WebExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class })
	@ResponseBody
	public ExceptionResponse handleException(NotFoundException e){
		return new ExceptionResponse("404", e.getMessage());
	}
}
