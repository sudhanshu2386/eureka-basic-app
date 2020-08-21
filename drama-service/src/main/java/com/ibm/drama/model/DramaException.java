package com.ibm.drama.model;

public class DramaException extends RuntimeException {

	private static final long serialVersionUID = 3940903789725183219L;

	private Integer errorCode;
	private String message;

	public DramaException() {
	}

	public DramaException(Integer errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
