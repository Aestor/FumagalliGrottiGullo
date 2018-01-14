/*
 * Copyright 2018 Pivotal Software, Inc..
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
package com.polimi.travlendar.backend.beans;

import com.polimi.fakePTS.PtsRequest;
import com.polimi.fakePTS.exceptions.InvalidFieldsException;
import com.polimi.fakePTS.tickets.Ticket;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import com.polimi.travlendar.backend.database.TrainTicketRowMapper;
import com.polimi.travlendar.backend.database.UrbanTicketRowMapper;
import com.polimi.travlendar.backend.model.user.User;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Notification;
import java.sql.Date;
import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Manages the Ticket Module. Allows creation of tickets and updates the database of tickets.
 * @author jaycaves
 */
@SpringComponent
@VaadinSessionScope
@Scope("session")
public class TicketService {

    @Autowired
    User user;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Verifies if user has enough balance to proceed, if so sends a payment
     * request to external PTS API. Response is a complete ticket or an
     * exception to alarm purchase process did not succeed. Distinguishes two
     * cases: train or urban tickets. Returns a string to be shown in the UI.
     *
     * @param tempTicket
     * @param selection
     * @return
     */
    public Notification purchase(Ticket tempTicket, String selection) {

        Long newBalance;
        Long oldBalance = jdbcTemplate.queryForObject("SELECT balance FROM users WHERE email = ?",
                new Object[]{user.getEmail()}, Long.class);
        
        switch (selection) {

            case "TRAIN": {

                TrainTicket real;

                newBalance = oldBalance - tempTicket.getPrice();

                if (newBalance > 0) {

                    try {

                        real = PtsRequest.buyTrainTicket(tempTicket.getPrice(), ((TrainTicket) tempTicket).getDepartureLocation(),
                                ((TrainTicket) tempTicket).getArrivalLocation(), tempTicket.getType(),
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

                        return new Notification("PURCHASE SUCCESSFULLY EXECUTED", Notification.Type.HUMANIZED_MESSAGE);

                    } catch (InvalidFieldsException e) {

                        return new Notification(e.getMessage(), Notification.Type.ERROR_MESSAGE);

                    }
                } else {

                    return new Notification("Error : insufficient balance to purchase ticket! \nGo to the Balance page to add more money in your Travlendar+ account", Notification.Type.ERROR_MESSAGE);
                }

            }

            case "URBAN": {

                UrbanTicket real;
                

                newBalance = oldBalance - tempTicket.getPrice();

                if (newBalance > 0) {

                    try {

                        real = PtsRequest.buyUrbanTicket(tempTicket.getPrice(), tempTicket.getType(),
                                ((UrbanTicket) tempTicket).getCity());

                        // INSERTION INTO DATABASE //
                        jdbcTemplate.update("INSERT INTO urban_tickets (id, ticketsid, ticket_type, city, price, validity, purchase_date, purchase_time, activated, lenght) "
                                + "VALUES (?,?,?,?,?,?,?,?,?,?)", user.getId(), real.getId(), real.getType().name, real.getCity(), real.getPrice(), real.getValidity(),
                                convertDate(real.getPurchase()), convertTime(real.getPurchase()), false, real.getLenght());

                        jdbcTemplate.update("UPDATE users SET balance = ? WHERE email= ?",
                                newBalance, user.getEmail());

                        user.setBalance(newBalance);

                        return new Notification("PURCHASE SUCCESSFULLY EXECUTED", Notification.Type.HUMANIZED_MESSAGE);

                    } catch (InvalidFieldsException e) {

                        return new Notification(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                } else {

                    return new Notification("Error : insufficient balance to purchase ticket! \nGo to the Balance page to add more money in your Travlendar+ account", Notification.Type.ERROR_MESSAGE);
                }

            }

            default: {

                //impossible to get here
                return null;
            }

        }
    }

    public List<TrainTicket> initTrains() {
        return jdbcTemplate.query("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{user.getId()}, new TrainTicketRowMapper());
    }

    public List<UrbanTicket> initUrbans() {
        return jdbcTemplate.query("SELECT * FROM urban_tickets WHERE id= ? ",
                new Object[]{user.getId()}, new UrbanTicketRowMapper());
    }

    /**
     * Saves in the DB that a certain train ticket has been activated.
     *
     * @param t
     */
    public void registerTrainActivation(TrainTicket t) {

        jdbcTemplate.update("UPDATE train_tickets SET activated= true WHERE id= ? and ticketsid =?",
                user.getId(), t.getId());
        jdbcTemplate.update("UPDATE train_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                Time.valueOf(t.getValidationTime().toLocalTime()), user.getId(), t.getId());

    }

    /**
     * Saves in the DB that a certain urban ticket has been activated.
     *
     * @param t
     */
    public void registerUrbanActivation(UrbanTicket t) {

        jdbcTemplate.update("UPDATE urban_tickets SET activated= true WHERE id= ? and ticketsid=? ",
                user.getId(), t.getId());
        jdbcTemplate.update("UPDATE urban_tickets SET validation_date= ? WHERE id= ? and ticketsid =?",
                Date.valueOf(t.getValidationTime().toLocalDate()), user.getId(), t.getId());
        jdbcTemplate.update("UPDATE urban_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                Time.valueOf(t.getValidationTime().toLocalTime()), user.getId(), t.getId());

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
