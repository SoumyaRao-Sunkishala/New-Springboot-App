package com.app.Exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(UserException.class)
	public CustomExceptionDetails userExceptionHandler(UserException userException,WebRequest wr)
	{
		CustomExceptionDetails customExceptionDetails = new CustomExceptionDetails(LocalDateTime.now(), userException.getMessage(), wr.getDescription(false));
		return customExceptionDetails;
	}
	
	@ExceptionHandler(Exception.class)
	public CustomExceptionDetails exceptionHandler(Exception exception,WebRequest wr)
	{
		CustomExceptionDetails customExceptionDetails = new CustomExceptionDetails(LocalDateTime.now(), exception.getMessage(), wr.getDescription(false));
		return customExceptionDetails;
	}
	
	
	
	

}
