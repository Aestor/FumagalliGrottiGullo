package com.polimi.travlendar.components;

import com.polimi.travlendar.User;
import com.polimi.travlendar.user.PreferenceLevel;
import java.time.ZonedDateTime;

public class Meeting {

    private User user;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String location;
    private String name;
    private String details;
    private State state;
    private PreferenceLevel level;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isEditable() {
        return state == State.planned;
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
