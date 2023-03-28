package br.com.storebr.webstore.sytem.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String message;
	private String detalis;
	
	public ExceptionResponse(Date timestamp, String message, String detalis) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detalis = detalis;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetalis() {
		return detalis;
	}
	
	
	
		
	
}
