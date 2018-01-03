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
package com.polimi.travlendar.backend.beans;

import com.polimi.travlendar.backend.database.MeetingRowMapper;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.model.events.Meeting;
import com.polimi.travlendar.backend.model.events.Meeting.State;
import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import java.sql.Date;
import java.sql.Time;
import java.time.ZonedDateTime;
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

    @Autowired
    User user;

    public long addMeeting(Meeting meeting) {

        jdbcTemplate.update("INSERT INTO events (id, location, nam, details, d, timeb, timee, preflevel, state) VALUES (?,?,?,?,?,?,?,?,?)",
                meeting.getUser(), meeting.getLocation(), meeting.getName(), meeting.getDetails(), convertDate(meeting.getStart()), convertTime(meeting.getStart()), convertTime(meeting.getEnd()), convertPref(meeting.getPreferenceLevel()), convertState(meeting.getState()));
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", long.class);
    }

    public void editMeeting(Meeting meeting) {
        jdbcTemplate.update("UPDATE events SET location = ?, nam = ?, details = ?, d = ?, timeb = ?, timee = ?, preflevel = ? WHERE id = ? AND eventid = ?", meeting.getLocation(), meeting.getName(), meeting.getDetails(), convertDate(meeting.getStart()), convertTime(meeting.getStart()), convertTime(meeting.getEnd()), meeting.getPreferenceLevel(), meeting.getUser(), meeting.getId());
    }

    public List<Meeting> getMeetings(User user) throws EmptyResultDataAccessException {
        List<Meeting> m = new ArrayList<>();
        try {
            m = jdbcTemplate.query("SELECT * FROM events WHERE id=?", new Object[]{user.getId()}, new MeetingRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw e;
        }
        return m;

    }

    private Time convertTime(ZonedDateTime t) {
        return Time.valueOf(t.toLocalTime());
    }

    private Date convertDate(ZonedDateTime t) {
        return Date.valueOf(t.toLocalDate());
    }

    private String convertPref(PreferenceLevel p) {
        switch (p) {
            case HIGH:
                return "HIGH";
            case MEDIUM:
                return "MEDIUM";
            case LOW:
                return "LOW";
            default:
                return null;
        }

    }

    private String convertState(State s) {
        switch (s) {
            case planned:
                return "planned";
            case started:
                return "started";
            case ended:
                return "ended";
            default:
                return null;
        }
    }
}
