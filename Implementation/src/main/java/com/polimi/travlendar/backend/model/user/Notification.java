package com.polimi.travlendar.backend.model.user;

/**
 * 
 * @author Emmeggi95
 *
 */
public class Notification {

	private String message;
	
	public Notification(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
