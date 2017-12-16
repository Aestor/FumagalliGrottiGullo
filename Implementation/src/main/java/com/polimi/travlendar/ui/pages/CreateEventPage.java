/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.ui.pages;

import com.polimi.travlendar.components.Schedule;
import com.polimi.travlendar.ui.CreateEventForm;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Paolo Fumagalli
 */

@SuppressWarnings("serial")
@SpringView(name = CreateEventPage.NAME)
public class CreateEventPage extends VerticalLayout implements View {

	public static final String NAME = "CreateEventPage";

	private CreateEventForm createEvent;

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		
		createEvent = new CreateEventForm((Schedule)VaadinSession.getCurrent().getAttribute("schedule"));
		addComponent(createEvent);
		
	}

}
