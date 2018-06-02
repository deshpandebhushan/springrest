package com.bd.mortgage.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Record Found for given input")
	@ExceptionHandler(RestClientException.class)
	public void handleNoResultException(Exception e){
		System.out.println(e);
		logger.error("handleNoResultException handler executed");
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Something went wrong please try again.")
	@ExceptionHandler(Exception.class)
	public final void handleAllExceptions(Exception e) {
		System.out.println(e);
		logger.error("handleAllExceptions handler executed");
	}
}
