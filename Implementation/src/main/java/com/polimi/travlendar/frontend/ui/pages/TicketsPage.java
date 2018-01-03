/*
 * Copyright 2017 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.polimi.travlendar.frontend.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.fakePTS.PtsRequest;
import com.polimi.fakePTS.exceptions.InvalidTicketException;
import com.polimi.fakePTS.tickets.Ticket;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.frontend.ui.forms.NewTicketForm;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.VerticalLayout;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Page dedicated to user's public transportation virtual tickets. Can purchase
 * or access his own ones.
 *
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = TicketsPage.NAME)
@MenuCaption("My Tickets")
@MenuIcon(VaadinIcons.TICKET)
public class TicketsPage extends VerticalLayout implements View {

    public static final String NAME = "Tickets Page";
    private List<TrainTicket> trains;
    private List<UrbanTicket> urbans;
    private FormLayout subform; // here form is dynamically loaded

    @Autowired
    User user;

    @Autowired
    NewTicketForm form;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        //fetch from database and displays if there are
        initMyTickets();

        //init new ticket purchase section
        Label head = new Label("PURCHASE TICKETS:");
        head.setStyleName("mytitle");
        this.addComponents(head, form);

    }

    /**
     * Core function than initializes content for this page. Tickets are fetched
     * from database and in case shown in the page
     */
    private void initMyTickets() {

        FormLayout subform; // here form is dynamically loaded
        RadioButtonGroup<String> selection;

        // From db through a TicketService
        trains = form.getService().initTrains();
        urbans = form.getService().initUrbans();

        // if user has tickets must be shown in the page
        if ((trains.size() > 0) || (urbans.size() > 0)) {

            //init my tickets section
            Label mytickets = new Label("MY TICKETS:\n");
            mytickets.setStyleName("mytitle");
            selection = new RadioButtonGroup<String>();
            selection.setItems("ALL", "ACTIVE", "EXPIRED");
            selection.setStyleName("tickets");
            subform = new FormLayout();
            addComponents(mytickets, selection, subform);
            
            selection.addValueChangeListener(e -> {
                
                subform.removeAllComponents();
                switch (selection.getValue()) {
                    case "ALL": {
                        subform.addComponent(new TicketDisplayer(trains, urbans));
                        break;
                    }
                    case "ACTIVE":{
                        subform.addComponent( new TicketDisplayer(
                    trains.stream().filter(u -> u.isActivated()&& !isExpired(u)).collect(Collectors.toList()),
                    urbans.stream().filter(u -> u.isActivated()&& !isExpired(u)).collect(Collectors.toList())));
                        break;
                    }
                    case "EXPIRED":{
                        subform.addComponent( new TicketDisplayer(
                    trains.stream().filter(u -> isExpired(u)).collect(Collectors.toList()),
                    urbans.stream().filter(u -> isExpired(u)).collect(Collectors.toList())));
                        break;
                    }
                }
            });

           

            //init activated tickets section
            Label atickets = new Label("MY ACTIVATED TICKETS:\n");
            atickets.setStyleName("mytitle");
            
        }
    }

    /**
     *
     * @param t
     * @return
     */
    private boolean isExpired(Ticket t) {
        if(t.getValidationTime()!=null){
        
            ZonedDateTime time ;
            switch(t.getType().name){
                case "single":{
                    return t.getValidationTime().plusMinutes(t.getValidity()).isAfter(ZonedDateTime.now(t.getValidationTime().getZone()));
                    
                }
                case "weekpass":{
                    return t.getValidationTime().plusDays(t.getValidity()).isAfter(ZonedDateTime.now(t.getValidationTime().getZone()));
                }
                case "onemonthpass":{
                    return t.getValidationTime().plusDays(t.getValidity()).isAfter(ZonedDateTime.now(t.getValidationTime().getZone()));
                    
                }
                case "yearpass":{
                    return t.getValidationTime().plusMonths(t.getValidity()).isAfter(ZonedDateTime.now(t.getValidationTime().getZone()));
                }
            }
        //something went wrong
        return false;
        }
        return false;
    }

    /**
     * Layout section to append user's tickets visual descriptor.
     */
    private class TicketDisplayer extends HorizontalLayout {

        public TicketDisplayer(List<TrainTicket> trains, List<UrbanTicket> urbans) {

            this.setResponsive(true);

            trains.forEach((t) -> {
                this.addComponent(drawTrainTicket(t));
            });

            urbans.forEach((t) -> {
                this.addComponent(drawUrbanTicket(t));

            });

        }

        private Panel drawTrainTicket(TrainTicket t) {
            Panel head = new Panel("Train Ticket with id: " + t.getId());
            head.setIcon(VaadinIcons.TRAIN);
            head.setSizeUndefined();
            head.setResponsive(true);
            VerticalLayout content = new VerticalLayout(new Label("Departure: " + t.getDepartureLocation()),
                    new Label("Arrival: " + t.getArrivalLocation()), new Label("Validity: " + t.getValidity() + " " + t.getLenght()+ " ON "+t.getValidationTime().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
            content.setResponsive(true);
            Button activate = new Button("Activate");
            content.addComponent(activate);
            if (!t.isActivated()) {
                activate.addClickListener(e -> {
                    try {
                        PtsRequest.activateTicket(t);
                        form.getService().registerTrainActivation(t);
                        Notification.show("Ticket Activated!");
                    } catch (InvalidTicketException er) {
                        Notification.show(er.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                });
            } else {
                activate.setEnabled(false);

            }
            head.setContent(content);
            return head;
        }

        private Panel drawUrbanTicket(UrbanTicket t) {
            Panel head = new Panel("Urban Ticket with id: " + t.getId());
            head.setIcon(VaadinIcons.INVOICE);
            head.setResponsive(true);
            head.setSizeUndefined();
            VerticalLayout content = new VerticalLayout(new Label("City: " + t.getCity()),
                    new Label("Type: " + t.getType()), new Label("Validity: " + t.getValidity() + " " + t.getLenght()));
            content.setResponsive(true);
            Button activate = new Button("Activate");
            content.addComponent(activate);
            if (!t.isActivated()) {
                activate.addClickListener(e -> {
                    try {
                        PtsRequest.activateTicket(t);
                        form.getService().registerUrbanActivation(t);
                        Notification.show("Ticket Activated!");
                    } catch (InvalidTicketException er) {
                        Notification.show(er.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                });
            } else {
                activate.setEnabled(false);

            }
            head.setContent(content);
            return head;
        }

    }

    private class TicketSection extends VerticalLayout {

    }
}
