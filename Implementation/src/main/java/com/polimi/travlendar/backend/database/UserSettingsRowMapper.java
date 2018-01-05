package com.polimi.travlendar.backend.database;

import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.model.user.UserSettings;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Contains the information necessary to map a SQL query result to a "UserSettings" Java
 * object.
 *
 * @author jaycaves
 *
 */
public class UserSettingsRowMapper implements RowMapper<UserSettings> {

    @Override
    public UserSettings mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        UserSettings userSettings = new UserSettings();
        userSettings.setCarPreference(PreferenceLevel.valueOf(rs.getString("car_preference_level").toUpperCase()));
        userSettings.setBikePreference(PreferenceLevel.valueOf(rs.getString("bike_preference_level").toUpperCase()));
        userSettings.setBikeAvailability(rs.getBoolean("bike_availability"));
        userSettings.setCarAvailability(rs.getBoolean("car_availability"));
        userSettings.setDrivingLicense(rs.getBoolean("driver_licence"));
        userSettings.setMaxWalkingDistance(rs.getInt("max_walk_distance"));

        return userSettings;
    }

   

}
