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
import com.polimi.travlendar.TicketRowMapper;
import com.polimi.travlendar.User;
import com.polimi.travlendar.user.Ticket;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.InlineDateTimeField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<Ticket> temp;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    User user;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        initMyTickets();

        //init my tickets section
        addComponents( new Label("MY TICKETS"), new TicketDisplayer());

        //init new ticket purchase section
        addComponent(new Label("PURCHASE TICKETS:\n"));
        addComponent(new NewTicketForm());
        Button ok = new Button("Purchase!");
        ok.addClickListener(e -> {
                purchase();
        });
        
        //init activated tickets section
        addComponent(new Label("MY ACTIVATED TICKETS:\n"));

    }

    private void initMyTickets() {

        temp = new ArrayList<>();

        temp = jdbcTemplate.query("SELECT * FROM tickets WHERE id= ? ", new Object[]{user.getId()}, new TicketRowMapper());
        
    }

    private void purchase() {
         
    }

    private class TicketDisplayer extends HorizontalLayout {

        public TicketDisplayer() {

            Resource res = new ThemeResource("qr.png");
            Image image = new Image("QR:", res);
            for (Ticket t : temp) {

                addComponents(new Panel("Ticket with id: "+t.getId(), new Panel(t.getCity(),new Panel("Validity: "+t.getValidity()+" minutes",image))));

            }
        }

    }

    private class NewTicketForm extends FormLayout {
            //to be extended
    }




}
