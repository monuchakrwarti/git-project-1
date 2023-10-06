package com.market_app_1.dto;

import java.util.Date;

public class ErrorDetails {
	private Date timing;
	private String message;
	private String details;
	
	public ErrorDetails(Date timing, String message, String details) {
		this.timing = timing;
		this.message = message;
		this.details = details;
	}

	public Date getTiming() {
		return timing;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
