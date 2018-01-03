package com.polimi.travlendar.frontend.ui.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;

import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.beans.UserService;
import com.polimi.travlendar.frontend.ui.TravlendarUI;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Notification.Type;

/**
 * Vaadin form to register.
 * @author Emmeggi95
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@Scope("prototype")
public class RegisterForm extends FormLayout implements View{
	
	@Autowired
	UserService service;
	
	private TextField email = new TextField("Email");
	private PasswordField password = new PasswordField("Password");
	private PasswordField confirm = new PasswordField("Confirm password");
	private TextField first_name = new TextField("First name");
	private TextField last_name = new TextField("Last name");
	private Button submit = new Button("Submit");
	
	private User input;
	
	private boolean confirmation;
	
	public RegisterForm() {
		
		setSizeUndefined();
		addComponents(email, password, confirm, first_name, last_name, submit);
		
		submit.setClickShortcut(KeyCode.ENTER);
		submit.addClickListener(e -> this.register());
		
		confirm.addBlurListener(e -> this.checkConfirm());
	}
	
	/**
	 * Checks if the password and its confirmation are identical.
	 */
	public void checkConfirm() {
		if(password.isEmpty() || confirm.isEmpty() || !password.getValue().equals(confirm.getValue())) {
			confirm.setComponentError(new UserError("The passwords must be the same"));
			confirmation = false;
		} else {
			confirm.setComponentError(null);
			confirmation = true;
		}
	}
	
	/**
	 * Through the {@link UserService} class, checks if the email entered is already registered on the database and, if not, registers him.
	 */
	private void register(){
		long dummy = 0;
		input = new User(dummy, email.getValue(), password.getValue(), first_name.getValue(), last_name.getValue());
		if (confirmation) {
			if (service.check(input.getEmail())) {
				service.addUser(input);
				try {
					((TravlendarUI) getUI()).setCurrentUser(service.getUser(input.getEmail(), input.getPassword()));
					VaadinSession.getCurrent().setAttribute("user", input.getEmail());
					((TravlendarUI) getUI()).setMenuBar();
				} catch (EmptyResultDataAccessException e) {
					e.printStackTrace();
					Notification.show("Internal error!", Type.ERROR_MESSAGE);
				}
			} else {
				new Notification("Error", "Email already used", 
						Notification.Type.WARNING_MESSAGE, true).show(Page.getCurrent());
			}
		} else {
			new Notification("Error", "The passwords must be the same",
					Notification.Type.ERROR_MESSAGE, true).show(Page.getCurrent());
		}
	}

}
