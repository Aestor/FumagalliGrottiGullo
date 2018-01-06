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
import java.sql.Timestamp;
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
@Scope("session")
public class EventService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    User user;

    /**
     * Adds an event in the database with the information sent by the user
     * through an EventForm. The database generates a unique id for each event.
     *
     * @param meeting the event to be saved in the database.
     */
    public void addMeeting(Meeting meeting) {

        jdbcTemplate.update("INSERT INTO events (id, starting_location, ending_location, nam, details, timeb, timee, preflevel, event_state, duration) VALUES (?,?,?,?,?,?,?,?,?,?)",
                meeting.getUser(), meeting.getStartingLocation(), meeting.getEndingLocation(), meeting.getName(), meeting.getDetails(), convertDateTime(meeting.getStart()), convertDateTime(meeting.getEnd()), convertPref(meeting.getPreferenceLevel()), convertState(meeting.getState()), meeting.getDuration());
    }

    /**
     * Modifies an already existing event in the database.
     *
     * @param meeting the event already modified.
     */
    public void editMeeting(Meeting meeting) {
        jdbcTemplate.update("UPDATE events SET starting_location = ?, ending_location = ?, nam = ?, details = ?, timeb = ?, timee = ?, preflevel = ?, duration = ? WHERE id = ? and eventid = ?", meeting.getStartingLocation(), meeting.getEndingLocation(), meeting.getName(), meeting.getDetails(), convertDateTime(meeting.getStart()), convertDateTime(meeting.getEnd()), convertPref(meeting.getPreferenceLevel()), meeting.getDuration(), meeting.getUser(), meeting.getId());
    }

    /**
     * Fetches from the database all the events connected to a user.
     *
     * @param user the user who's events are extracted.
     * @return a list of all the events of the user.
     * @throws EmptyResultDataAccessException
     */
    public List<Meeting> getMeetings(User user) throws EmptyResultDataAccessException {
        List<Meeting> m = new ArrayList<>();
        try {
            m = jdbcTemplate.query("SELECT * FROM events WHERE id=?", new Object[]{user.getId()}, new MeetingRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw e;
        }
        return m;

    }

    /**
     * Deletes an event from the database.
     *
     * @param meeting the event to be deleted.
     */
    public void deleteMeeting(Meeting meeting) {
        jdbcTemplate.execute("DELETE FROM events WHERE eventid=" + meeting.getId() + ";");
    }

    /**
     * Converts a ZonedDateTIme object to a Timestamp
     *
     * @param t the object to be converted.
     * @return the object converted.
     */
    private Timestamp convertDateTime(ZonedDateTime t) {
        return Timestamp.valueOf(t.toLocalDateTime());
    }

    /**
     * Converts a PreferenceLevel object into a String. It is used to make it easier to
     * communicate with the database.
     *
     * @param p the PreferenceLevel object to be converted.
     * @return the PreferenceLevel object as a String
     */
    private String convertPref(PreferenceLevel p) {
        switch (p) {
            case HIGH:
                return "HIGH";
            case MEDIUM:
                return "MEDIUM";
            case LOW:
                return "LOW";
            default:
                return "HIGH";
        }

    }
/**
 * Converts a State object into a String. It is used to make it easier to
 * communicate with the database.
 * @param s the State object to be converted.
 * @return the State object as a String
 */
    private String convertState(State s) {
        switch (s) {
            case planned:
                return "planned";
            case started:
                return "started";
            case ended:
                return "ended";
            default:
                return "planned";
        }
    }
}
