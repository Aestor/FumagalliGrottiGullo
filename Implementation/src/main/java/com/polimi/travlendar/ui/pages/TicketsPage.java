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
package com.polimi.travlendar.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.fakePTS.PtsRequest;
import com.polimi.fakePTS.exceptions.InvalidTicketException;
import com.polimi.travlendar.TrainTicketRowMapper;
import com.polimi.travlendar.UrbanTicketRowMapper;
import com.polimi.travlendar.User;
import com.polimi.travlendar.ui.NewTicketForm;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    User user;

    @Autowired
    NewTicketForm form;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        //fetch from database and displays if there are
        initMyTickets();

        //init new ticket purchase section
        addComponent(form);
        form.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        

    }

    /**
     * Core function than initializes content for this page. Tickets are fetched
     * from database and in case shown in the page
     */
    private void initMyTickets() {

        trains = jdbcTemplate.query("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{user.getId()}, new TrainTicketRowMapper());
        urbans = jdbcTemplate.query("SELECT * FROM urban_tickets WHERE id= ? ",
                new Object[]{user.getId()}, new UrbanTicketRowMapper());

        // if user has tickets must be shown in the page
        if ((trains.size() > 0) || (urbans.size() > 0)) {

            //init my tickets section
            addComponents(new Label("MY TICKETS:\n"), new TicketDisplayer(trains, urbans));

            //init activated tickets section
            addComponents(new Label("MY ACTIVATED TICKETS:\n"),
                    new TicketDisplayer(
                            trains.stream().filter(u -> u.isActivated()).collect(Collectors.toList()),
                            urbans.stream().filter(u -> u.isActivated()).collect(Collectors.toList())));
        }
    }

    /**
     * Saves in the DB that a certain train ticket has been activated.
     * @param t 
     */
    private void registerTrainActivation(TrainTicket t) {

        jdbcTemplate.update("UPDATE train_tickets SET activated= true WHERE id= ? and ticketsid =?",
                user.getId(), t.getId());
        jdbcTemplate.update("UPDATE train_tickets SET validation_date= ? WHERE id= ? and ticketsid =?",
                Date.valueOf(t.getValidationTime().toLocalDate()), user.getId(), t.getId());
        jdbcTemplate.update("UPDATE train_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                Time.valueOf(t.getValidationTime().toLocalTime()), user.getId(), t.getId());

    }
/**
 * Saves in the DB that a certain urban ticket has been activated.
 * @param t 
 */
    private void registerUrbanActivation(UrbanTicket t) {

        jdbcTemplate.update("UPDATE urban_tickets SET activated= true WHERE id= ? and ticketsid=? ",
                user.getId(), t.getId());
        jdbcTemplate.update("UPDATE urban_tickets SET validation_date= ? WHERE id= ? and ticketsid =?",
                Date.valueOf(t.getValidationTime().toLocalDate()), user.getId(), t.getId());
        jdbcTemplate.update("UPDATE urban_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                Time.valueOf(t.getValidationTime().toLocalTime()), user.getId(), t.getId());

    }

    /**
     * Layout section to append user's tickets visual descriptor.
     */
    private class TicketDisplayer extends HorizontalLayout {

        public TicketDisplayer(List<TrainTicket> trains, List<UrbanTicket> urbans) {
            
            this.setResponsive(true);
            //Resource res = new ThemeResource("qr.png");
            //Image image = new Image("QR:", res);
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
                    new Label("Arrival: " + t.getArrivalLocation()), new Label("Validity: " + t.getValidity() + " " + t.getLenght()));
           content.setResponsive(true);
            Button activate = new Button("Activate");
                content.addComponent(activate);
            if (!t.isActivated()) { 
                activate.addClickListener(e -> {
                    try {
                        PtsRequest.activateTicket(t);
                        registerTrainActivation(t);
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
                        registerUrbanActivation(t);
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
}
