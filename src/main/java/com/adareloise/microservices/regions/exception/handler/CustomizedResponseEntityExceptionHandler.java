package com.adareloise.microservices.regions.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adareloise.microservices.regions.exception.ExceptionResponse;
import com.adareloise.microservices.regions.exception.global.CommuneNotFoundException;
import com.adareloise.microservices.regions.exception.global.ProvinceNotFoundException;
import com.adareloise.microservices.regions.exception.global.RegionNotFoundException;


/**
 * Country exception handler.
 * <p>
 * Exception message is set here when exception occur.
 */
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
     * Region not found error exception.
     *
     * @param ex, request
     * @return
     */
	@ExceptionHandler(RegionNotFoundException.class)
	public final ResponseEntity<Object> regionNotFoundException(Exception ex, WebRequest request ){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	
	}
	

	/**
     * Province not found error exception.
     *
     * @param ex, request
     * @return
     */
	@ExceptionHandler(ProvinceNotFoundException.class)
	public final ResponseEntity<Object> provinceNotFoundException(Exception ex, WebRequest request ){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	
	}
	
	/**
     * Commune not found error exception.
     *
     * @param ex, request
     * @return
     */
	@ExceptionHandler(CommuneNotFoundException.class)
	public final ResponseEntity<Object> communeeNotFoundException(Exception ex, WebRequest request ){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	
	}
	
}
