package com.ppm.domain.execption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public BadRequestException(String message) {
		super(message);
		this.message = message;
	}

	public BadRequestException() {
		super();
	}

}
