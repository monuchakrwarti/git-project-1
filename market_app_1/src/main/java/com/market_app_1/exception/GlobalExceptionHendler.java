package com.market_app_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.market_app_1.dto.ErrorDetails;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHendler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception exception, WebRequest webRequest){
		
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
}
