package com.polimi.travlendar;

import org.springframework.context.annotation.Scope;

import com.vaadin.spring.annotation.SpringComponent;

/**
 * 
 * @author Emmeggi95
 *
 */
@SpringComponent
@Scope("singleton")
public class NotificationManager {
	
	// Singleton pattern

	private static NotificationManager instance = null;
	
	protected NotificationManager() {}
	
	public NotificationManager getInstance() {
		if(instance == null)
			instance = new NotificationManager();
		return instance;
	}
	
	// Singleton test (it works!! See TestingPage)
	
	private String text;

	public String getText() {
		if(text == null)
			text = "";
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
