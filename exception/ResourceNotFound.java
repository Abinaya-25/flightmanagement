package com.flight.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND)//404
public class ResourceNotFound extends RuntimeException {
	private static final long serialVersionUID =1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public ResourceNotFound(String resourceName, String fieldName, Object fieldValue) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getresourceName() {
		return resourceName;
	}
	public String getfieldName() {
		return fieldName;
	}
	public Object getfieldValue() {
		return fieldValue;
		}
	
	

}
