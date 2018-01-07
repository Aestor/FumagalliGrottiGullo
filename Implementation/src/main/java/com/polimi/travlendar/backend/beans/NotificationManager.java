package com.polimi.travlendar.backend.beans;

import com.polimi.travlendar.backend.model.user.Notification;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;

import com.vaadin.spring.annotation.SpringComponent;

/**
 *  For future notifications' feature
 * @author Emmeggi95
 *
 */
@SpringComponent
@Scope("singleton")
public class NotificationManager extends Thread{
	
	// Singleton pattern

	private static NotificationManager instance = null;
	
	protected NotificationManager() {}
	
	public NotificationManager getInstance() {
		if(instance == null)
			instance = new NotificationManager();
		return instance;
	}
	
	// Notifications
	
	private HashMap<String, List<Notification>> nextNotifications;
	
	private HashMap<String, List<Notification>> currentNotifications;
	
	@Override
	public void run() {
		while(true) {
			try {
				wait(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				// Reboot NotificationManager if interrupted
			}
		}
	}
	
	// Singleton test (it works!! See TestingPage)
	
	private String globalMessage;

	public String getText() {
		if(globalMessage == null)
			globalMessage = "";
		return globalMessage;
	}

	public void setText(String text) {
		this.globalMessage = text;
	}
	
	
}
