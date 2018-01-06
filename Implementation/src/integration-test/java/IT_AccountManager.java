

import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.model.user.UserSettings;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

/**
 * Runs component tests for UserService;
 * @author jaycaves
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class IT_AccountManager{
   
    
    @MockBean
    private JdbcTemplate jdbcTemplate;
    
    @Before
    public void setUp() {
        
        User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
        UserSettings settings= new UserSettings(PreferenceLevel.HIGH, PreferenceLevel.MEDIUM, 0, true, true, true);
        
        
        // ALL QUERIES REGARDING EXAMPLE USER AND USER SETTINGS //
        Mockito.when(jdbcTemplate.queryForObject("SELECT id FROM users WHERE email=?", new Object[]{user.getEmail()}, Long.class)).thenReturn(user.getId());
        Mockito.when(jdbcTemplate.queryForObject("SELECT password FROM users WHERE email=?", new Object[]{user.getEmail()}, String.class)).thenReturn(user.getPassword());
        Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=? AND password=?", new Object[]{user.getEmail(), user.getPassword()}, User.class)).thenReturn(user);
        Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM user_settings WHERE id =? ", new Object[]{user.getId()}, UserSettings.class)).thenReturn(settings);
        Mockito.when( jdbcTemplate.update("INSERT INTO users (email, password, first_name, last_name,balance,stripeId) VALUES (?, ?, ?, ?,?,?)",
                user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name(), new Long(0), "none")).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE users SET first_name=?, last_name=?, password=?  WHERE id= ?",
                user.getFirst_name(), user.getLast_name(), user.getPassword(), user.getId())).thenReturn(1);
        Mockito.when( jdbcTemplate.update("INSERT INTO user_settings (id, car_preference_level, bike_preference_level, bike_availability, car_availability,driver_licence, max_walk_distance) VALUES (?,?, ?, ?, ?,?,?)",
                user.getId(), "Low", "Low", false, false, false, 999)).thenReturn(1);
        Mockito.when(jdbcTemplate.update("UPDATE user_settings SET  car_preference_level= ?, bike_preference_level= ?, bike_availability= ?, car_availability= ?,driver_licence= ?, max_walk_distance= ? WHERE id= ?",
                settings.getCarPreference().getPreference(), settings.getBikePreference().getPreference(),
                settings.isBikeAvailability(), settings.isCarAvailability(),
                settings.isDrivingLicense(), settings.getMaxWalkingDistance(), user.getId())).thenReturn(1);
        
    }
    
    /**
     * Test of check method, of class UserService.
     */
    @Test
    public void testCheck() {
        
        String email = "example@hotmail.it";
        
       
       Long id = jdbcTemplate.queryForObject("SELECT id FROM users WHERE email=?", new Object[]{email}, Long.class);
        Assert.assertNotNull(id);
        
    
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() {
        
       User use = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
        
        jdbcTemplate.update("INSERT INTO users (email, password, first_name, last_name,balance,stripeId) VALUES (?, ?, ?, ?,?,?)",
                use.getEmail(), use.getPassword(), use.getFirst_name(), use.getLast_name(), new Long(1), "none");
       User registered= jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=? AND password=?", new Object[]{use.getEmail(), use.getPassword()}, User.class);
         
       assertEquals(use.toString(), registered.toString());
       
    }

    /**
     * Test of authenticate method, of class UserService.
     */
    @Test
    public void testAuthenticate() {
        
       User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
       String password = jdbcTemplate.queryForObject("SELECT password FROM users WHERE email=?", new Object[]{user.getEmail()}, String.class);
       assertEquals(user.getPassword(),password);
    }

    /**
     * Test of getUser method, of class UserService.
     */
    @Test
    public void testGetUser() {
        User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
        User result = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=? AND password=?", new Object[]{user.getEmail(),user.getPassword()}, User.class);
       assertEquals(user.toString(), result.toString());
    }

    /**
     * Test of updateUser method, of class UserService.
     */
    @Test
    public void testUpdateUser() {
         User user = new User(new Long(1),"example@hotmail.it", "gigio", "Harry", "Kane");
         jdbcTemplate.update("UPDATE users SET first_name=?, last_name=?, password=?  WHERE id= ?",
                "Pablo", "Escobar", "password", user.getId());
         User registered=jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=? AND password=?", new Object[]{user.getEmail(), "password"}, User.class);
      assertNotEquals(user.toString(), registered.toString());
        
    }

    /**
     * Test of addPreferences method, of class UserService.
     */
    @Test
    public void testAddPreferences() {
       UserSettings settings= new UserSettings(PreferenceLevel.HIGH, PreferenceLevel.MEDIUM, 0, true, true, true);
       User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
       jdbcTemplate.update("INSERT INTO user_settings (id, car_preference_level, bike_preference_level, bike_availability, car_availability,driver_licence, max_walk_distance) VALUES (?,?, ?, ?, ?,?,?)",
             user.getId()   , "Low", "Low", false, false, false, 999);
       UserSettings result= jdbcTemplate.queryForObject("SELECT * FROM user_settings WHERE id =? ", new Object[]{user.getId()}, UserSettings.class);
       
       assertEquals(settings.toString(), result.toString());
  
  
       
    }

    /**
     * Test of updatePreferences method, of class UserService.
     */
    @Test
    public void testUpdatePreferences() {
        
       UserSettings settings= new UserSettings(PreferenceLevel.LOW, PreferenceLevel.LOW, 0, false, true, true);
       User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");
       jdbcTemplate.update("UPDATE user_settings SET  car_preference_level= ?, bike_preference_level= ?, bike_availability= ?, car_availability= ?,driver_licence= ?, max_walk_distance= ? WHERE id= ?",
                PreferenceLevel.HIGH, PreferenceLevel.MEDIUM, true, true,true, 0, user.getId());
       UserSettings result = jdbcTemplate.queryForObject("SELECT * FROM user_settings WHERE id =? ", new Object[]{user.getId()}, UserSettings.class);
       
       assertNotEquals(settings.toString(), result.toString());
  
    }

    /**
     * Test of getPreferences method, of class UserService.
     */
    @Test
    public void testGetPreferences() {
   
   UserSettings settings= new UserSettings(PreferenceLevel.HIGH, PreferenceLevel.MEDIUM, 0, true, true, true);
       User user = new User(new Long(1),"example@hotmail.it", "password", "Pablo", "Escobar");     
       jdbcTemplate.update("UPDATE user_settings SET  car_preference_level= ?, bike_preference_level= ?, bike_availability= ?, car_availability= ?,driver_licence= ?, max_walk_distance= ? WHERE id= ?",
                PreferenceLevel.HIGH, PreferenceLevel.MEDIUM, true, true,true, 0, user.getId());
       UserSettings results = jdbcTemplate.queryForObject("SELECT * FROM user_settings WHERE id =? ", new Object[]{user.getId()}, UserSettings.class);
       
       assertEquals(settings.toString(), results.toString());
    }
}
