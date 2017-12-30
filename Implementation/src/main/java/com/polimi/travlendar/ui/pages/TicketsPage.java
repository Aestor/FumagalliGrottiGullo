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
import com.polimi.travlendar.TrainTicketRowMapper;
import com.polimi.travlendar.UrbanTicketRowMapper;
import com.polimi.travlendar.User;
import com.polimi.travlendar.ui.NewTicketForm;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
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
        addComponents(new Label("PURCHASE TICKETS:\n"), form);

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
            addComponents(new Label("MY TICKETS:\n"), new TicketDisplayer());

            //init activated tickets section
            addComponent(new Label("MY ACTIVATED TICKETS:\n"));
            Resource res = new ThemeResource("qr.png");
            Image image = new Image("QR:", res);

            trains.stream().filter((t) -> (t.isActivated())).forEachOrdered((t) -> {
                addComponents(new Panel("Ticket with id: " + t.getId(), new Panel("Departure: " + t.getDepartureLocation(),
                        new Panel("Arrival: " + t.getArrivalLocation(), new Panel("Validity: " + t.getValidity() + " "+ t.getLenght())))));
            });
            urbans.stream().filter((t) -> (t.isActivated())).forEachOrdered((t) -> {
                addComponents(new Panel("Ticket with id: " + t.getId(), new Panel("City: " + t.getCity(),
                        new Panel("Validity: " + t.getValidity() + "", image))));
            });
        }
    }

    /**
     * Layout section to append user's tickets visual descriptor.
     */
    private class TicketDisplayer extends HorizontalLayout {

        public TicketDisplayer() {

            Resource res = new ThemeResource("qr.png");
            Image image = new Image("QR:", res);

            trains.forEach((t) -> {
                addComponents(new Panel("Train Ticket with id: " + t.getId(), new Panel("Departure: " + t.getDepartureLocation(),
                        new Panel("Arrival: " + t.getArrivalLocation(), new Panel("Validity: " + t.getValidity() + " "+ t.getLenght())))));
            });

            urbans.forEach((t) -> {
                addComponents(new Panel("Urban Ticket with id: " + t.getId(), new Panel("City: " + t.getCity(),
                        new Panel("Validity: " + t.getValidity() + "", image))));
            });
        }

    }
}
