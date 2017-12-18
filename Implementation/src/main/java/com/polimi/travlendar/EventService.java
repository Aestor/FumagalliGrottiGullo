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

import com.polimi.travlendar.components.Meeting;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * This class handles SQL queries to the database concerning the object
 * "Meeting".
 *
 * @author Paolo
 */
@SpringComponent
@VaadinSessionScope
@Scope("prototype")
public class EventService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMeeting(Meeting meeting) {
        jdbcTemplate.update("INSERT INTO events (id, location, nam, details, d, timeb, timee, preflevel) VALUES (?,?,?,?,?,?,?)",
                meeting.getUser().getId(), meeting.getLocation(), meeting.getName(), meeting.getDetails(), meeting.getStart().toLocalDate(), meeting.getStart().toLocalTime(), meeting.getEnd().toLocalTime(), meeting.getPreferenceLevel());
    }

    public List<Meeting> getMeetings(User user) throws EmptyResultDataAccessException {
        List<Meeting> m = new ArrayList<>();
        long i = user.getId();
        try {
         //  m = jdbcTemplate.queryForList("SELECT * FROM events WHERE id =?", Meeting);
         // m = jdbcTemplate.queryForList("SELECT * FROM events WHERE id=?", i, Meeting.class);
        } catch ( EmptyResultDataAccessException e) {
            throw e;
        }
        return m;
        
    }
}
