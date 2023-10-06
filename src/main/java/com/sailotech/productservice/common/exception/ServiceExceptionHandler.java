package com.sailotech.productservice.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sailotech.productservice.dto.ErrorDto;

@ControllerAdvice()
public class ServiceExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	//@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorDto> handleException(RuntimeException ex) {
		var error = new ErrorDto();
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	//@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorDto> handleException(Exception ex) {
		var error = new ErrorDto();
		error.setMessage("ahh!!!");
		
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
