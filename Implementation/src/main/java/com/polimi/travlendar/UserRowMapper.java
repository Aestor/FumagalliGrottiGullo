package com.polimi.travlendar;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Contains the information necessary to map a SQL query result to a "User" Java object.
 * @author Emmeggi95
 *
 */
public class UserRowMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setFirst_name(rs.getString("first_name"));
		user.setLast_name(rs.getString("last_name"));
                                user.setStripeId(rs.getString("stripeId"));
                                user.setBalance(rs.getLong("balance"));
		return user;
	}
        
        

}
