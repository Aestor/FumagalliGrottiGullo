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


import com.polimi.travlendar.backend.model.events.Meeting;
import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import com.polimi.travlendar.backend.model.user.User;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.evosuite.shaded.org.mockito.Mock;
import org.evosuite.shaded.org.mockito.MockitoAnnotations;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Runs some test for the service layer of EventService;
 * @author jaycaves
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class IT_EventModule {
    
    @MockBean
    private JdbcTemplate jdbcTemplate;
    

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        Meeting[] meetings= new Meeting[5];
        Meeting meeting = new Meeting(0, ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) ,ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) , "Milano", "Zena", "EVENT", 10, "details", Meeting.State.started, PreferenceLevel.LOW, 0, true);
        User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
        meetings[1] =meeting;
        // HERE WITH FAKE SOME DATABASE ENTRY //
        Mockito.when( jdbcTemplate.update("INSERT INTO events (id, starting_location, ending_location, nam, details, timeb, timee, preflevel, event_state, duration) VALUES (?,?,?,?,?,?,?,?,?,?)",
                meeting.getUser(), meeting.getStartingLocation(), meeting.getEndingLocation(), meeting.getName(), meeting.getDetails(), meeting.getStart(), meeting.getEnd(), meeting.getPreferenceLevel(), meeting.getState(), meeting.getDuration())).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE events SET starting_location = ?, ending_location = ?, nam = ?, details = ?, timeb = ?, timee = ?, preflevel = ?, duration = ? WHERE id = ? and eventid = ?", meeting.getStartingLocation(), meeting.getEndingLocation(), meeting.getName(), meeting.getDetails(), meeting.getStart(), meeting.getEnd(), meeting.getPreferenceLevel(), meeting.getDuration(), meeting.getUser(), meeting.getId())).thenReturn(1);
        Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM events WHERE id=?", new Object[]{meeting.getId()}, Meeting.class)).thenReturn(meeting);
        Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM events WHERE id=?", new Object[]{user.getId()}, Meeting.class)).thenReturn(meeting);
        Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM events WHERE id=?", new Object[]{user.getId()}, Meeting[].class)).thenReturn(meetings);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMeeting method, of class EventService.
     */
    @Test
    public void testAddMeeting() {
           
      Meeting meeting = new Meeting(0, ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) ,ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) , "Milano", "Zena", "EVENT", 10, "details", Meeting.State.started, PreferenceLevel.LOW, 0, true);
        User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
        jdbcTemplate.update("INSERT INTO events (id, starting_location, ending_location, nam, details, timeb, timee, preflevel, event_state, duration) VALUES (?,?,?,?,?,?,?,?,?,?)",
                meeting.getUser(), meeting.getStartingLocation(), meeting.getEndingLocation(), meeting.getName(), meeting.getDetails(), meeting.getStart(), meeting.getEnd(), meeting.getPreferenceLevel(), meeting.getState(), meeting.getDuration());
        Meeting result = jdbcTemplate.queryForObject("SELECT * FROM events WHERE id=?", new Object[]{meeting.getId()}, Meeting.class);
        assertEquals(result.toString(), meeting.toString());
    }

    /**
     * Test of editMeeting method, of class EventService.
     */
    @Test
    public void testEditMeeting() {
        Meeting meeting = new Meeting(0, ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) ,ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) , "Milano", "Zena", "EVENT", 10, "details", Meeting.State.started, PreferenceLevel.LOW, 0, true);
        User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
        jdbcTemplate.update("UPDATE events SET starting_location = ?, ending_location = ?, nam = ?, details = ?, timeb = ?, timee = ?, preflevel = ?, duration = ? WHERE id = ? and eventid = ?", meeting.getStartingLocation(), meeting.getEndingLocation(), meeting.getName(), meeting.getDetails(), meeting.getStart(), meeting.getEnd(), meeting.getPreferenceLevel(), meeting.getDuration(), meeting.getUser(), meeting.getId());
        Meeting result = jdbcTemplate.queryForObject("SELECT * FROM events WHERE id=?", new Object[]{meeting.getId()}, Meeting.class);
        assertEquals(result.toString(), meeting.toString());
    }

    /**
     * Test of getMeetings method, of class EventService.
     */
    @Test
    public void testGetMeetings() {
        Meeting[] meetings = new Meeting[5];
        Meeting meeting = new Meeting(0, ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) ,ZonedDateTime.of(LocalDateTime.MAX, ZoneId.systemDefault()) , "Milano", "Zena", "EVENT", 10, "details", Meeting.State.started, PreferenceLevel.LOW, 0, true);
        meetings[1] =meeting;
        User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
        Meeting[] result = jdbcTemplate.queryForObject("SELECT * FROM events WHERE id=?", new Object[]{user.getId()}, Meeting[].class);
        Meeting results = result[1];
        assertEquals(meeting.toString(), results.toString());

    }

   
}
