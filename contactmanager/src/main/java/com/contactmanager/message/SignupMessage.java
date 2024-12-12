package com.contactmanager.message;

public class SignupMessage {
	
	private String message;
	private String type;
	public SignupMessage() {}
	
	public SignupMessage(String message, String type) {
		super();
		this.message = message;
		this.type = type;
	}
	@Override
	public String toString() {
		return "SignupMessage [message=" + message + ", type=" + type + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
