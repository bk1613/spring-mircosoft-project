package com.synex.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler({IOException.class, SafeShutdownException.class})
	public ResponseEntity<String> handleExceptions(Exception ex){
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}
	
}
