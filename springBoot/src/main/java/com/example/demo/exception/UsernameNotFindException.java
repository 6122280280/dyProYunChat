package com.example.demo.exception;

public class UsernameNotFindException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private boolean propertiesKey = true;
	public UsernameNotFindException(String message, String errorCode, boolean propertiesKey) {
		super(message);
		this.setErrorCode(errorCode);
		this.setPropertiesKey(propertiesKey);
	};
	public UsernameNotFindException(String message) {
		super(message);
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public boolean isPropertiesKey() {
		return propertiesKey;
	}
	public void setPropertiesKey(boolean propertiesKey) {
		this.propertiesKey = propertiesKey;
	}
	
}
