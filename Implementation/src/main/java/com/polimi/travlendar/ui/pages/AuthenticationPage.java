package com.polimi.travlendar.ui.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.travlendar.ui.LoginForm;
import com.polimi.travlendar.ui.RegisterForm;
import com.polimi.travlendar.ui.TravlendarUI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Page to manage user's login and registration.
 * @author Emmeggi95
 *
 */
@SuppressWarnings("serial")
@SpringView(name = AuthenticationPage.NAME)
@MenuCaption("Logout")
@MenuIcon(VaadinIcons.EXIT)
public class AuthenticationPage extends VerticalLayout implements View {
	public static final String NAME = "authentication";

	@Autowired
	private LoginForm loginForm;
	@Autowired
	private RegisterForm registerForm;

	private Button login;
	private Button register;
	
	private Button logout;

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		if (VaadinSession.getCurrent().getAttribute("user") == null) {
			login = new Button("Login");
			register = new Button("Register");
			HorizontalLayout options = new HorizontalLayout(login, register);

			this.addComponents(options, loginForm, registerForm);
			this.setComponentAlignment(options, Alignment.TOP_CENTER);
			this.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
			this.setComponentAlignment(registerForm, Alignment.MIDDLE_CENTER);

			loginForm.setVisible(false);
			registerForm.setVisible(false);

			login.addClickListener(e -> {
				registerForm.setVisible(false);
				loginForm.setVisible(true);
			});
			register.addClickListener(e -> {
				loginForm.setVisible(false);
				registerForm.setVisible(true);
			});
		} else {
			logout = new Button("Logout");
			Label message = new Label("Click Logout if you want to end your session");
			this.addComponents(message, logout);
			logout.addClickListener(e -> {
				VaadinSession.getCurrent().setAttribute("user", null);
				((TravlendarUI) getUI()).setUnloggedMenuBar();
			});
			this.setComponentAlignment(message, Alignment.TOP_CENTER);
			this.setComponentAlignment(logout, Alignment.MIDDLE_CENTER);
		}

	}

}
