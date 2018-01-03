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
package com.polimi.travlendar.frontend.ui.forms;

import com.polimi.fakePTS.PtsRequest;
import com.polimi.fakePTS.exceptions.InvalidFieldsException;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.fakePTS.tickets.Ticket;
import com.polimi.fakePTS.tickets.TicketType;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import com.polimi.travlendar.backend.beans.TicketService;
import com.polimi.travlendar.frontend.ui.pages.TicketsPage;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Component used in new tickets' purchases.
 *
 * @author jaycaves
 * @author Paolo
 */
@SuppressWarnings("serial")
@SpringComponent
@Scope("prototype")
public class NewTicketForm extends HorizontalLayout {

    @Autowired
    User user;

    @Autowired
     TicketService service;

    RadioButtonGroup<String> selection;
    Ticket tempTicket;
    FormLayout subform; // here form is dynamically loaded
    

    public NewTicketForm() {
       
        this.setResponsive(true);
        selection = new RadioButtonGroup<String>("Choose Ticket type:");
        selection.setItems("TRAIN", "URBAN");
        selection.setStyleName("tickets");
        subform = new FormLayout();
        
        selection.addValueChangeListener(e -> {
            setFormContent(subform);
        });

        addComponents(selection, subform);
     
        
    }

    /**
     * Dynamically fills page with entry fields for the chosen ticket type.
     *
     * @param ssubformubform
     */
    private void setFormContent(FormLayout subform) {

        subform.removeAllComponents(); //refresh
        switch (selection.getValue()) {

            case "TRAIN": {

                DateField date = new DateField("Choose the date: "); //must choose validation date a priori
                NativeSelect<String> start = new NativeSelect<>("Starting from: ");
                NativeSelect<String> end = new NativeSelect<>("Arriving at: ");
                start.setItems(PtsRequest.getAvailableTrainStations());
                end.setItems(PtsRequest.getAvailableTrainStations());
                start.setEmptySelectionAllowed(false);
                end.setEmptySelectionAllowed(false);

                /*FOR FUTURE DEVELOPMENT: 
                Allow different passes in Train ticket's purchase, such as weekly, monthly, etc...
                 */
                date.setDateFormat("dd-MM-yyyy");
                date.setRangeStart(LocalDate.now());
                Button ok = new Button("Purchase!");
                ok.addClickListener(e -> {

                    if ((!start.isEmpty()) && (!end.isEmpty()) && (!start.getValue().equals(end.getValue()))) {

                        if (!date.isEmpty()) {
                            //use fake ticket to temporarly store input data (validity not established here)
                            int price = PtsRequest.getTrainPrice(start.getValue(), end.getValue());
                            tempTicket = new TrainTicket(start.getValue(), end.getValue(), price,
                                    TicketType.SINGLE);
                            tempTicket.setValidationTime(ZonedDateTime.of(date.getValue().atTime(LocalTime.MIN), ZoneId.systemDefault()));
                            UI.getCurrent().addWindow(new TicketPurchaseRecap());

                        } else {

                            Notification.show("Please insert valid date", Notification.Type.ERROR_MESSAGE);

                        }
                    } else {

                        Notification.show("Please insert valid locations", Notification.Type.ERROR_MESSAGE);

                    }

                });

                subform.addComponents(date, start, end, ok);
                
                break;

            }
            case "URBAN": {

                NativeSelect<String> city = new NativeSelect<>("City: ");
                NativeSelect<String> type = new NativeSelect<>("Choose ticket type:");
                type.setItems(TicketType.getValues());
                city.setItems(PtsRequest.getAvailableCities());
                type.setEmptySelectionAllowed(false);
                city.setEmptySelectionAllowed(false);

                Button ok = new Button("Purchase!");
                ok.addClickListener(e -> {

                    if ((!city.isEmpty()) && (!type.isEmpty())) {
                        //use fake ticket to temporarly store input data (validity not established here)
                        int price = PtsRequest.getUrbanPrice(TicketType.valueOf(type.getValue().toUpperCase()));
                        tempTicket = new UrbanTicket(price,
                                TicketType.valueOf(type.getValue().toUpperCase()), city.getValue());
                        UI.getCurrent().addWindow(new TicketPurchaseRecap());
                    } else {

                        Notification.show("Please insert valid fields", Notification.Type.ERROR_MESSAGE);

                    }
                });

                subform.addComponents(city, type, ok);
                break;
            }
            default: {

                subform.addComponent(new Label("Something went wrong: Invalid RadioButton selection in TicketsPage"));
            }

        }

    }

    /**
     * Sub-window where ticket details pop up once form is completely filled.
     */
    private class TicketPurchaseRecap extends Window {

        public TicketPurchaseRecap() {

            super("Ticket Purchase Recap");
            center();
            setModal(true);
            setClosable(true);
            Button ok = new Button("Confirm purchase", e -> {
                purchase();
                close();
            });
            Button no = new Button("Go back", e -> {
                close();
            });
            VerticalLayout layout = new VerticalLayout();
            TextArea area = new TextArea();
            area.setReadOnly(true);
            area.setEnabled(false);
            area.setValue("Purchase recap:" + "\n\n" + tempTicket.toString());
            area.setWidth("300px");
            area.setHeight("300px");
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.addComponents(ok, no);
            layout.addComponents(area, buttons);
            setContent(layout);

        }
    }

  
    /**
     * When called passes necessary parameters to a TicketService in order to process purchase request. 
     * Result is displayed with a Notification
     */
    private void purchase() {
        
        Notification result = service.purchase(tempTicket, selection.getValue());
        Notification.show(result.getCaption());
         super.getUI().getNavigator().navigateTo(TicketsPage.NAME);
    }

   public TicketService getService(){
       return service;
   }

}
