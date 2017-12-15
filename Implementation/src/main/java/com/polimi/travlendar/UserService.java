package com.polimi.travlendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;

/**
 * This class handles SQL queries to the database concerning the object "User".
 * @author Emmeggi95
 *
 */
@SpringComponent
@VaadinSessionScope
@Scope("prototype")
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Checks if the String passed as a parameter is already present in the database as an email.
     * @param email
     * @return
     */
    public boolean check(String email) {
        try {
            jdbcTemplate.queryForObject("SELECT id FROM users WHERE email=?", new Object[]{email}, long.class);
        } catch (EmptyResultDataAccessException e) {
            return true;
        }
        return false;

    }

    /**
     * Adds a user in the database with the information stored by the User object passed as a parameter. The user's id is automatically generated by the database.
     * @param user
     */
    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO users (email, password, first_name, last_name) VALUES (?, ?, ?, ?)",
                user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name());
    }

    public boolean authenticate(User user) throws EmptyResultDataAccessException {
        String password;
        try {
            password = jdbcTemplate.queryForObject("SELECT password FROM users WHERE email=?", new Object[]{user.getEmail()}, String.class);
        } catch (EmptyResultDataAccessException e) {
            throw e;
        }
        return password.equals(user.getPassword());

    }
    
    /**
     * Returns every information about the user stored in the database with corresponding email and password.
     * @param email
     * @param password
     * @return
     * @throws EmptyResultDataAccessException
     */
    public User getUser(String email, String password) throws EmptyResultDataAccessException{
    	User result;
    	try {
    		result = (User) jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=? AND password=?", new Object[] {email, password}, new UserRowMapper());
    	} catch (EmptyResultDataAccessException e) {
    		throw e;
    	}
    	return result;
    }

    public void extractData(User user) {
        
        //for settings data fetch

    }

}
