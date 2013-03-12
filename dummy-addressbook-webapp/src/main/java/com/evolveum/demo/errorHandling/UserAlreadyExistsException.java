package com.evolveum.demo.errorHandling;

import java.sql.SQLException;

public class UserAlreadyExistsException extends Exception{

	public UserAlreadyExistsException() {
		super();
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
