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
package com.polimi.fakePTS;

import com.polimi.fakePTS.exceptions.InvalidFieldsException;
import com.polimi.fakePTS.exceptions.InvalidTicketException;
import com.polimi.fakePTS.tickets.Ticket;
import com.polimi.fakePTS.tickets.TicketType;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Here we simulate RPC calls to a PTS API. Since no PTS service in our country
 * grants access to their purchase system, but we assumed it possible in our
 * RASD and DD, we decided to fake all the calls through this interface. Its
 * implementation, PtsRequest allows the user to virtually buy and activate
 * tickets.
 *
 * @author jaycaves
 */
public class PtsRequest {

    /**
     * Allows purchased tickets' activation
     * @param ticket
     * @throws InvalidTicketException 
     */
    public static void activateTicket(Ticket ticket) throws InvalidTicketException {

        if (ticket.isActivated()) {
            throw new InvalidTicketException("Error: Ticket is already validated");
        } else {
            if ((ticket.getValidationTime() != null) && (!ticket.getValidationTime().toLocalDate().equals(LocalDate.now(ticket.getValidationTime().getZone())))) {
                throw new InvalidTicketException("Could not activate ticket: today does not correspond with the prefixed day ");
            } else {
                ticket.setActivated(true);
                ticket.setValidationTime(ZonedDateTime.now());
            }
        }
    }

    /**
     * Allows Urban Tickets purchases.
     * @param price
     * @param type
     * @param validity
     * @param city
     * @return
     * @throws InvalidFieldsException 
     */
    public static UrbanTicket buyUrbanTicket(int price, TicketType type, String city) throws InvalidFieldsException {

        if (price > 0) {
            UrbanTicket temp
                    = new UrbanTicket(price, type, city);
            return temp;
        } else {
            throw new InvalidFieldsException("error");
        }

    }

    /**
     * Allows Train Tickets purchases.
     * @param price
     * @param start
     * @param arrival
     * @param validity
     * @param type
     * @param date
     * @return
     * @throws InvalidFieldsException 
     */
    public static TrainTicket buyTrainTicket(int price, String start, String arrival, TicketType type, LocalDate date) throws InvalidFieldsException {

        if (price > 0) {
            TrainTicket temp
                    = new TrainTicket(start, arrival, price, type);
            temp.setValidationTime(ZonedDateTime.of(date.atTime(LocalTime.MIN), ZoneId.systemDefault()));
            return temp;
        } else {
            throw new InvalidFieldsException("error");
        }
    }

    /**
     * Returns a list of available Train Stations in tickets' purchases.
     *
     * @return
     */
    public static List<String> getAvailableTrainStations() {
        List<String> temp = new ArrayList<>();
        temp.add("Milano");
        temp.add("Bergamo");
        temp.add("Genova");
        temp.add("Orio");
        temp.add("Brescia");
        temp.add("Lecco");
        return temp;
    }

    /**
     * Returns the cities Travlendar can sell tickets of.
     * @return 
     */
    public static List<String> getAvailableCities() {
        List<String> temp = new ArrayList<>();
        temp.add("Milano");
        temp.add("Bergamo");
        temp.add("Genova");
        temp.add("Orio");
        temp.add("Belluno");
        temp.add("Trieste");
        return temp;
    }

    /**
     * Return the tickets' prices according to a-priori value agreed.
     * @param type
     * @return 
     */
    public static int getUrbanPrice(TicketType type) {

        switch (type.name) {
            case "single":
                return 2;
            case "weekpass":
                return 20;
            case "onemonthpass":
                return 35;
            case "yearpass":
                return 250;
            default:
                return 1000000000;
        }
    }

   /**
    * Returns a price for a certain train. For now this price is generated randomly.
    * @param departure
    * @param arrival
    * @return 
    */
    public static int getTrainPrice(String departure, String arrival) {
        return ThreadLocalRandom.current().nextInt(0, 30);
    }
}
