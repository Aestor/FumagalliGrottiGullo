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
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Paolo
 */
public class MeetingRowMapper implements RowMapper<Meeting> {

    @Override
    public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
        Meeting meeting = new Meeting(false);
        meeting.setName(rs.getString("nam"));
        meeting.setDetails(rs.getString("details"));
        meeting.setLocation(rs.getString("location"));
        
        
        
        return null;
    }

}
