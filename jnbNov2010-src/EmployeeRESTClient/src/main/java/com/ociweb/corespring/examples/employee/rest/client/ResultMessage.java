package com.ociweb.corespring.examples.employee.rest.client;

public class ResultMessage {
	private int code;
	private String message;
	
	public ResultMessage() {
		super();
	}

	public ResultMessage(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
