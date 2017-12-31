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
package com.polimi.travlendar.ui;

import com.polimi.fakePTS.PtsRequest;
import com.polimi.fakePTS.exceptions.InvalidFieldsException;
import com.polimi.travlendar.User;
import com.polimi.fakePTS.tickets.Ticket;
import com.polimi.fakePTS.tickets.TicketType;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import com.polimi.travlendar.ui.pages.TicketsPage;
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
import com.vaadin.ui.TextField;
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
public class NewTicketForm extends FormLayout {

    @Autowired
    User user;

    @Autowired
    JdbcTemplate jdbcTemplate;

    RadioButtonGroup<String> selection;
    Ticket tempTicket;
    FormLayout subform; // here form is dynamically loaded
    HashMap<String, String> details; // form data are collected in here

    public NewTicketForm() {
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.addComponent(new Label("PURCHASE TICKETS:"));
        this.setResponsive(true);
        selection = new RadioButtonGroup<String>("Choose Ticket type:");
        selection.setItems("TRAIN", "URBAN");
        subform = new FormLayout();
        subform.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
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
                                    TicketType.SINGLE, 300);
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
                                TicketType.valueOf(type.getValue().toUpperCase()), 100, city.getValue());
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
     * Verifies if user has enough balance to proceed, if so sends a payment
     * request to external PTS API. Response is a complete ticket or an
     * exception to alarm purchase process did not succeed. Distinguishes two
     * cases: train or urban tickets.
     */
    private void purchase() {

        switch (selection.getValue()) {

            case "TRAIN": {

                TrainTicket real;
                Long newBalance;

                newBalance = user.getBalance() - tempTicket.getPrice();
                if (newBalance > 0) {

                    try {

                        real = PtsRequest.buyTrainTicket(tempTicket.getPrice(), ((TrainTicket) tempTicket).getDepartureLocation(),
                                ((TrainTicket) tempTicket).getArrivalLocation(), tempTicket.getValidity(), tempTicket.getType(),
                                tempTicket.getValidationTime().toLocalDate());

                        // INSERTION INTO DATABASE //
                        jdbcTemplate.update("INSERT INTO train_tickets (id, ticketsid, ticket_type, departure_location, arrival_location, "
                                + "price, validity, purchase_date, purchase_time, validation_date, validation_time, activated, lenght) "
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", user.getId(), real.getId(), real.getType().name, real.getDepartureLocation(),
                                real.getArrivalLocation(), real.getPrice(), real.getValidity(), convertDate(real.getPurchase()),
                                convertTime(real.getPurchase()), convertDate(real.getValidationTime()), convertTime(real.getValidationTime()),
                                false, real.getLenght());

                        jdbcTemplate.update("UPDATE users SET balance = ? WHERE email= ?",
                                newBalance, user.getEmail());

                        user.setBalance(newBalance);

                        Notification.show("PURCHASE SUCCESSFULLY EXECUTED", Notification.Type.HUMANIZED_MESSAGE);

                    } catch (InvalidFieldsException e) {

                        Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                } else {

                    Notification.show("Error : insufficient balance to purchase ticket! \nGo to the Balance page to add more money in your Travlendar+ account", Notification.Type.ERROR_MESSAGE);
                }
                break;

            }

            case "URBAN": {

                UrbanTicket real;
                Long newBalance;

                newBalance = user.getBalance() - tempTicket.getPrice();

                if (newBalance > 0) {

                    try {

                        real = PtsRequest.buyUrbanTicket(tempTicket.getPrice(), tempTicket.getType(), tempTicket.getValidity(),
                                ((UrbanTicket) tempTicket).getCity());

                        // INSERTION INTO DATABASE //
                        jdbcTemplate.update("INSERT INTO urban_tickets (id, ticketsid, ticket_type, city, price, validity, purchase_date, purchase_time, activated, lenght) "
                                + "VALUES (?,?,?,?,?,?,?,?,?,?)", user.getId(), real.getId(), real.getType().name, real.getCity(), real.getPrice(), real.getValidity(),
                                convertDate(real.getPurchase()), convertTime(real.getPurchase()), false, real.getLenght());

                        jdbcTemplate.update("UPDATE users SET balance = ? WHERE email= ?",
                                newBalance, user.getEmail());

                        user.setBalance(newBalance);

                        Notification.show("PURCHASE SUCCESSFULLY EXECUTED", Notification.Type.HUMANIZED_MESSAGE);

                    } catch (InvalidFieldsException e) {

                        Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                } else {

                    Notification.show("Error : insufficient balance to purchase ticket!", "Go to the Balance page to add more money in your Travlendar+ account", Notification.Type.ERROR_MESSAGE);
                }
                break;
            }

            default: {

                //impossible to get here
            }

            super.getUI().getNavigator().navigateTo(TicketsPage.NAME);

        }
    }

    /**
     * Converts ZoneDateTime into Time to write data in database.
     *
     * @param t
     * @return
     */
    private Time convertTime(ZonedDateTime t) {
        return Time.valueOf(t.toLocalTime());
    }

    /**
     * Converts ZoneDateTime into Date to write data in database.
     *
     * @param t
     * @return
     */
    private Date convertDate(ZonedDateTime t) {
        return Date.valueOf(t.toLocalDate());
    }

}
