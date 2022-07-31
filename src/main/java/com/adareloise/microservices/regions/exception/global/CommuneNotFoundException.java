package com.adareloise.microservices.regions.exception.global;

import org.springframework.dao.DataAccessException;

@SuppressWarnings("serial")
public class CommuneNotFoundException extends DataAccessException {

	public CommuneNotFoundException(String s) {
		super(s);
	}
	
	public CommuneNotFoundException(String s, Throwable throwable) {
		super(s, throwable);
	}

}
