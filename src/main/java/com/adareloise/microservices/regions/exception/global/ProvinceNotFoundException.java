package com.adareloise.microservices.regions.exception.global;

import org.springframework.dao.DataAccessException;

@SuppressWarnings("serial")
public class ProvinceNotFoundException extends DataAccessException {

	public ProvinceNotFoundException(String s) {
		super(s);
	}
	
	public ProvinceNotFoundException(String s, Throwable throwable) {
		super(s, throwable);
	}

}
