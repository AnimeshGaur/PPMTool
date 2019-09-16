package com.ppm.domain.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class BadRequestException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BadRequestException(String message) {
		super(message);
		this.message = message;
	}

	public BadRequestException() {
		super();
	}

}
