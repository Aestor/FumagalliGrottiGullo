package com.polimi.travlendar.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;

import com.polimi.travlendar.User;
import com.polimi.travlendar.UserService;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Notification.Type;

/**
 * Vaadin form to login.
 * @author Emmeggi95
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@Scope("prototype")
public class LoginForm extends FormLayout {

	@Autowired
	private UserService service;
	
	@Autowired User user;
	
	private TextField email = new TextField("Email");
	private PasswordField password = new PasswordField("Password");
	private Button submit = new Button("Submit");

	private User input;

	public LoginForm() {

		setSizeUndefined();
		addComponents(email, password, submit);

		submit.setClickShortcut(KeyCode.ENTER);

		submit.addClickListener(e -> this.submit());
	}

	/**
	 * Checks if the information entered is correct through the {@link UserService} class.
	 */
	public void submit() {
		input = new User(email.getValue(), password.getValue());
		Boolean authenticated;
		try {
			authenticated = service.authenticate(input);
		} catch (EmptyResultDataAccessException e) {
			Notification.show("This email was not registered", Notification.Type.ERROR_MESSAGE);
			return;
		}
		if (authenticated) {
			try {
				user.setUser(service.getUser(input.getEmail(), input.getPassword()));
				VaadinSession.getCurrent().setAttribute("user", input.getEmail());
				((TravlendarUI) getUI()).setMenuBar();
			} catch (EmptyResultDataAccessException e) {
				e.printStackTrace();
				Notification.show("Internal error!", Type.ERROR_MESSAGE);
			}

		} else {
			Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
		}
	}
}
