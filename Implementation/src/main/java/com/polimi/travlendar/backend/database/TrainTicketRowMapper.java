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
package com.polimi.travlendar.backend.database;

import com.polimi.fakePTS.tickets.TicketType;
import com.polimi.fakePTS.tickets.TrainTicket;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jaycaves
 * @author aestor
 */
public class TrainTicketRowMapper implements RowMapper<TrainTicket> {

    @Override
    public TrainTicket mapRow(ResultSet rs, int rowNum) throws SQLException {

        TrainTicket ticket = new TrainTicket("", "", 0, TicketType.SINGLE); //default value, will be overwritten
        ticket.setId(rs.getString("ticketsid"));
        ticket.setDepartureLocation(rs.getString("departure_location"));
        ticket.setArrivalLocation(rs.getString("arrival_location"));
        ticket.setActivated(rs.getBoolean("activated"));
        ticket.setValidity(rs.getInt("validity"));
        ticket.setType( TicketType.valueOf(rs.getString("ticket_type").toUpperCase()));
        ticket.setPrice(rs.getInt("price"));
        ticket.setLenght(rs.getString("lenght"));
        ticket.setValidationTime(convertDateTime(rs.getTime("validation_time"), rs.getDate("validation_date")));
        ticket.setPurchase(convertDateTime(rs.getTime("purchase_time"), rs.getDate("purchase_date")));
        return ticket;
    }
    
    private ZonedDateTime convertDateTime(Time t, Date d) {
        return ZonedDateTime.of(d.toLocalDate(), t.toLocalTime(), ZoneId.systemDefault());

    }

}
