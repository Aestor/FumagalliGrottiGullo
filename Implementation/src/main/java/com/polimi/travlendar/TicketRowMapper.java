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
package com.polimi.travlendar;

import com.polimi.travlendar.user.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author jaycaves
 */
public class TicketRowMapper implements RowMapper<Ticket> {

    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getString("id"));
        ticket.setName(rs.getString("customername"));
        ticket.setLastname(rs.getString("customerlastname"));
        ticket.setCity(rs.getString("city"));
        ticket.setDate(rs.getDate("d"));
        ticket.setActivated(rs.getBoolean("activated"));
        ticket.setValidity(rs.getInt("validity"));
        return ticket;
    }

}
