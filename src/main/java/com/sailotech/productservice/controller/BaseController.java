package com.sailotech.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sailotech.productservice.dto.ErrorDto;

public class BaseController {

	/*
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDto handleException(RuntimeException ex) {
		var error = new ErrorDto();
		error.setMessage(ex.getMessage());
		
		return error;
	}
	*/

}
