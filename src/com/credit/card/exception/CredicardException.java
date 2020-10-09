/**
 * 
 */
package com.credit.card.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author sairam
 *
 */
public class CredicardException extends RuntimeException implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 839020388L;
	private String errorMsg;
	private HttpStatus errorCode;

	
	
	public CredicardException(String errorMsg, HttpStatus errorCode) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "CredicardException [errorMsg=" + errorMsg + ", errorCode=" + errorCode + "]";
	}

}
