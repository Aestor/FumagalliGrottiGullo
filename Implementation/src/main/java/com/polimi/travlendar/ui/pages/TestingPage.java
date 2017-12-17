package com.polimi.travlendar.ui.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.polimi.travlendar.NotificationManager;
import com.polimi.travlendar.User;
import com.polimi.travlendar.ui.AddCardForm;
import com.polimi.travlendar.ui.CheckoutForm;
import com.polimi.travlendar.ui.pages.gmaps.MapsAddOnPage;
import com.polimi.travlendar.ui.pages.gmaps.MapsPage;
import com.polimi.travlendar.ui.pages.gmaps.PlaceSearchPage;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Page with debug and testing aim.
 * @author Emmeggi95
 *
 */
@SuppressWarnings("serial")
@SpringView(name = TestingPage.NAME)
@MenuCaption("Test")
public class TestingPage extends VerticalLayout implements View{
	
	public static final String NAME = "test";
	
	@Autowired
	private User user;
	
	@Autowired
	private NotificationManager manager;
	
	@Autowired
	private AddCardForm cardForm;
        
                
	
	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		Button auth = new Button("Authentication");
		Button map = new Button("Google Maps");
		Button mapAddon = new Button("Google Maps Addon");
		Button placeSearch = new Button("Place search");
		Button scheduleMegaBella = new Button("Schedule più bella di tutte le altre che abbiamo fatto");
		Button tricky = new Button("Tricky");
		
		this.addComponents(new Label("Testing page"), auth, map, mapAddon, placeSearch, scheduleMegaBella, tricky);
		
		auth.addClickListener(e -> getUI().getNavigator().navigateTo(AuthenticationPage.NAME));
		map.addClickListener(e -> getUI().getNavigator().navigateTo(MapsPage.NAME));
		mapAddon.addClickListener(e -> getUI().getNavigator().navigateTo(MapsAddOnPage.NAME));
		placeSearch.addClickListener(e -> getUI().getNavigator().navigateTo(PlaceSearchPage.NAME));
		scheduleMegaBella.addClickListener(e -> getUI().getNavigator().navigateTo(SchedulePage.NAME));
		tricky.addClickListener(e -> getUI().getNavigator().navigateTo("tricky"));
		
		// Session information
		
		Label info = new Label();
		info.setContentMode(ContentMode.HTML);
		if(VaadinSession.getCurrent().getAttribute("user")==null) {
			info.setValue("Unlogged user");
		} else {
			info.setValue("Current user: " + user.getEmail() + "<br>ID: " + user.getId());
		}
		this.addComponent(info);
		
		// Testing Vaadin singleton
		
		HorizontalLayout managerTesting = new HorizontalLayout();
		Label explain = new Label("Global message (every session sees the same text): ");
		TextField input = new TextField();
		input.setPlaceholder("Enter global message");
		input.setValue(manager.getText());
		Button submit = new Button("Submit");
		Button update = new Button("Update");
		update.addClickListener(e -> input.setValue(manager.getText()));
		submit.addClickListener(e -> manager.setText(input.getValue()));
		managerTesting.addComponents(explain, input, submit, update);
		this.addComponent(managerTesting);
		
		// Payment form
		
		this.addComponent(cardForm);
                                
	}

}
