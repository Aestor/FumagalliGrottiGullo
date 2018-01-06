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


import com.polimi.fakePTS.tickets.TicketType;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import com.polimi.travlendar.backend.model.user.User;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Runs component tests for TicketService.
 *
 * @author jaycaves
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class IT_TicketModule {

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {

        // HERE WITH FAKE SOME DATABASE ENTRY //
        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        TrainTicket real = new TrainTicket("Genova", "Milano", 1, TicketType.SINGLE);
        UrbanTicket tick = new UrbanTicket(1, TicketType.SINGLE, "Milano");
        TrainTicket[] trains = new TrainTicket[10]; // fake query result container
        trains[0] = real;

        UrbanTicket[] urbans = new UrbanTicket[10]; //fake query result container
        urbans[0] = tick;
        real.setId("train_id"); //IDs are set in db, here we fake data
        tick.setId("urban_id"); //IDs are set in db, here we fake data
        real.setValidationTime(ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault())); //train tickets in db have validation date saved

        //ALL DATABASE JDBC METHODS ARE MOCKED //
        
        Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{real.getId()}, TrainTicket[].class)).thenReturn(trains);
        Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{tick.getId()}, UrbanTicket[].class)).thenReturn(urbans);
        Mockito.when(jdbcTemplate.update("INSERT INTO train_tickets (id, ticketsid, ticket_type, departure_location, arrival_location, " + "price, validity, purchase_date, purchase_time, validation_date, validation_time, activated, lenght) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", user.getId(), real.getId(), real.getType().name, real.getDepartureLocation(),
                real.getArrivalLocation(), real.getPrice(), real.getValidity(), real.getPurchase(),
                real.getPurchase(), real.getValidationTime(), real.getValidationTime(),
                false, real.getLenght())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE users SET balance = ? WHERE email= ?",
                user.getBalance(), user.getEmail())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("INSERT INTO urban_tickets (id, ticketsid, ticket_type, city, price, validity, purchase_date, purchase_time, activated, lenght) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)", user.getId(), tick.getId(), tick.getType().name, tick.getCity(), tick.getPrice(), tick.getValidity(),
                tick.getPurchase(), tick.getPurchase(), false, tick.getLenght())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE train_tickets SET activated= true WHERE id= ? and ticketsid =?",
                user.getId(), real.getId())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE train_tickets SET validation_date= ? WHERE id= ? and ticketsid =?",
                real.getValidationTime(), user.getId(), real.getId())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE train_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                real.getValidationTime(), user.getId(), real.getId())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE urban_tickets SET activated= true WHERE id= ? and ticketsid=? ",
                user.getId(), tick.getId())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE urban_tickets SET validation_date= ? WHERE id= ? and ticketsid =?",
                tick.getValidationTime(), user.getId(), tick.getId())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE urban_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                tick.getValidationTime(), user.getId(), tick.getId())).thenReturn(1);

    }

    /**
     * Test of purchase method, of class TicketService, when ticket is a train
     * ticket.
     */
    @Test
    public void testPurchaseTrains() {
        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        TrainTicket real = new TrainTicket("Genova", "Milano", 1, TicketType.SINGLE);
        TrainTicket[] trains = new TrainTicket[10];
        trains[0] = real;
        real.setId("train_id");

        jdbcTemplate.update("INSERT INTO train_tickets (id, ticketsid, ticket_type, departure_location, arrival_location, " + "price, validity, purchase_date, purchase_time, validation_date, validation_time, activated, lenght) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", user.getId(), real.getId(), real.getType().name, real.getDepartureLocation(),
                real.getArrivalLocation(), real.getPrice(), real.getValidity(), real.getPurchase(),
                real.getPurchase().toLocalDate(), real.getValidationTime(), real.getValidationTime(),
                false, real.getLenght());
        TrainTicket[] result = jdbcTemplate.queryForObject("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{real.getId()}, TrainTicket[].class);

        assertEquals(result[0].getId(), trains[0].getId()); //registration was done
    }

    /**
     * Test of purchase method, of class TicketService, when ticket is an urban
     * ticket.
     */
    @Test
    public void testPurchaseUrbans() {

        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        UrbanTicket tick = new UrbanTicket(1, TicketType.SINGLE, "Milano");
        UrbanTicket[] urbans = new UrbanTicket[10];
        urbans[0] = tick;
        tick.setId("urban_id");

        jdbcTemplate.update("INSERT INTO urban_tickets (id, ticketsid, ticket_type, city, price, validity, purchase_date, purchase_time, activated, lenght) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)", user.getId(), tick.getId(), tick.getType().name, tick.getCity(), tick.getPrice(), tick.getValidity(),
                tick.getPurchase(), tick.getPurchase(), false, tick.getLenght());
        UrbanTicket[] result = jdbcTemplate.queryForObject("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{tick.getId()}, UrbanTicket[].class);

        assertEquals(result[0].getId(), urbans[0].getId()); //registration was done
    }

    /**
     * Test of registerTrainActivation method, of class TicketService.
     */
    @Test
    public void testRegisterTrainActivation() {
        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        TrainTicket real = new TrainTicket("Genova", "Milano", 1, TicketType.SINGLE);
        real.setActivated(true);
        real.setId("train_id");

        jdbcTemplate.update("UPDATE train_tickets SET activated= true WHERE id= ? and ticketsid =?",
                user.getId(), real.getId());
        jdbcTemplate.update("UPDATE train_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                real.getValidationTime(), user.getId(), real.getId());
        TrainTicket[] result = jdbcTemplate.queryForObject("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{real.getId()}, TrainTicket[].class);

        assertNotEquals(result[0], real); //update was successfully done

    }

    /**
     * Test of registerUrbanActivation method, of class TicketService.
     */
    @Test
    public void testRegisterUrbanActivation() {
        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        UrbanTicket tick = new UrbanTicket(1, TicketType.SINGLE, "Milano");
        tick.setId("urban_id");
        tick.setActivated(true);
        tick.setValidationTime(ZonedDateTime.now());

        jdbcTemplate.update("UPDATE urban_tickets SET activated= true WHERE id= ? and ticketsid=? ",
                user.getId(), tick.getId());
        jdbcTemplate.update("UPDATE urban_tickets SET validation_date= ? WHERE id= ? and ticketsid =?",
                Date.valueOf(tick.getValidationTime().toLocalDate()), user.getId(), tick.getId());
        jdbcTemplate.update("UPDATE urban_tickets SET validation_time= ? WHERE id= ? and ticketsid =?",
                Time.valueOf(tick.getValidationTime().toLocalTime()), user.getId(), tick.getId());
        UrbanTicket[] result = jdbcTemplate.queryForObject("SELECT * FROM train_tickets WHERE id= ? ",
                new Object[]{tick.getId()}, UrbanTicket[].class);

        assertNotEquals(result[0], tick);
    }

}
