package com.example.demo.dto;

import java.util.Arrays;

public class SmsRequest {

	private String phoneNumber;

	private final String message;



	private String[] recipients;


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public SmsRequest(String message, String[] recipients, String phoneNumber) {
		this.message = message;
		this.recipients = recipients;
		this.phoneNumber = phoneNumber;
	}

	public String[] getRecipients() {
		return recipients;
	}


	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}


	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "SmsRequest [message=" + message + ", recipients=" + Arrays.toString(recipients) + "]";
	}

}
