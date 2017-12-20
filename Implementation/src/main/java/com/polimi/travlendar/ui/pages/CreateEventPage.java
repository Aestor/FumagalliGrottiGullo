/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.travlendar.EventService;
import com.polimi.travlendar.components.Schedule;
import com.polimi.travlendar.ui.CreateEventForm;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Paolo Fumagalli
 */
@SuppressWarnings("serial")
@SpringView(name = CreateEventPage.NAME)
@MenuIcon(VaadinIcons.CALENDAR_USER)
public class CreateEventPage extends VerticalLayout implements View {

    public static final String NAME = "CreateEventPage";
    @Autowired
    private CreateEventForm createEvent;
    @Autowired
    private EventService service;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        createEvent.setSchedule((Schedule) VaadinSession.getCurrent().getAttribute("schedule"));
        addComponent(createEvent);

    }

}
