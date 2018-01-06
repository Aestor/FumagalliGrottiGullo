package com.polimi.travlendar.backend.model.events;

import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import java.time.ZonedDateTime;

/**
 * This class represents each event that will be created by the user. This class
 * will be contained in the calendar, which will show each meeting.
 *
 * @author Aestor
 */
public class Meeting {

    private long user;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String startingLocation;
    private String endingLocation;
    private String name;
    private long duration;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(String endingLocation) {
        this.endingLocation = endingLocation;
    }
    private String details;
    private State state;
    private PreferenceLevel level;
    private long id;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isLongTime() {
        return longTime;
    }

    public void setLongTime(boolean longTime) {
        this.longTime = longTime;
    }

    public enum State {
        planned, started, ended
    }

    public PreferenceLevel getLevel() {
        return level;
    }

    public void setLevel(PreferenceLevel level) {
        this.level = level;
    }

    private boolean longTime;

    public Meeting(boolean longTime) {
        this.longTime = longTime;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public String getLocation() {
        return startingLocation;
    }

    public void setLocation(String location) {
        this.startingLocation = location;
    }

    public void setDetails(String details) {
        this.details = details;
    }
/**
 * This method returns false makes it impossible to edit the event directly inside the schedule.
 * @return 
 */
    public boolean isEditable() {
        return false;
    }

    public boolean isLongTimeEvent() {
        return longTime;
    }

    public PreferenceLevel getPreferenceLevel() {
        return level;
    }

    public void setPreferenceLevel(PreferenceLevel other) {
        this.level = other;
    }

}
