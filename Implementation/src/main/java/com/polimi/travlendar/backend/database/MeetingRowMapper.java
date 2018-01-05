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

import com.polimi.travlendar.backend.model.events.Meeting;
import com.polimi.travlendar.backend.model.events.Meeting.State;
import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Paolo
 */
public class MeetingRowMapper implements RowMapper<Meeting> {

    @Override
    public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
        Meeting meeting = new Meeting(false);
        meeting.setUser(rs.getLong("id"));
        meeting.setName(rs.getString("nam"));
        meeting.setDetails(rs.getString("details"));
        meeting.setStartingLocation(rs.getString("starting_location"));
        meeting.setEndingLocation(rs.getString("ending_location"));
        meeting.setStart(convertDateTime(rs.getTimestamp("timeb")));
        meeting.setEnd(convertDateTime(rs.getTimestamp("timee")));
        meeting.setPreferenceLevel(convertPref(rs.getString("preflevel")));
        meeting.setState(convertState(rs.getString("event_state")));
        meeting.setId(rs.getLong("eventid"));
        meeting.setDuration(rs.getLong("duration"));
        return meeting;
    }

    private ZonedDateTime convertDateTime(Timestamp t) {
        return ZonedDateTime.of(t.toLocalDateTime(), ZoneId.systemDefault());
    }
    
    
    private PreferenceLevel convertPref(String e) {
        switch(e) {
            case "HIGH":
                return PreferenceLevel.HIGH;
            case "MEDIUM":
                return PreferenceLevel.MEDIUM;
            case "LOW":
                return PreferenceLevel.LOW;
            default:
                    return null;
        }
        
    }
    
    private State convertState(String s) {
        switch(s) {
            case "planned":
                return State.planned;
            case "started":
                return State.started;
            case "ended":
                return State.ended;
            default:
                return null;
        }
    }
}
