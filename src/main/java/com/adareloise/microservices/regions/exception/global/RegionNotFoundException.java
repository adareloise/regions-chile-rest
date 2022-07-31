package com.adareloise.microservices.regions.exception.global;

import org.springframework.dao.DataAccessException;

@SuppressWarnings("serial")
public class RegionNotFoundException extends DataAccessException {

	public RegionNotFoundException(String s) {
		super(s);
	}
	
	public RegionNotFoundException(String s, Throwable throwable) {
		super(s, throwable);
	}

}
