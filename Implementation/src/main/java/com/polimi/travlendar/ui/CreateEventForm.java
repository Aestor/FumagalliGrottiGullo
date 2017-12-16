package com.polimi.travlendar.ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.dao.EmptyResultDataAccessException;

import com.polimi.travlendar.components.Meeting;
import com.polimi.travlendar.components.Meeting.State;
import com.polimi.travlendar.components.Schedule;
import com.polimi.travlendar.components.TimeSelectorComponent;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class CreateEventForm extends FormLayout {

	private TextField location = new TextField("Location");
	private TextField name = new TextField("Event");
	private TextField description = new TextField("Description");
	private DateField date = new DateField("Date");
	private Button submit = new Button("Submit");
	private Schedule schedule;
	private VerticalLayout content;
	private TimeSelectorComponent startingTime = new TimeSelectorComponent("Starting time");
	private TimeSelectorComponent endingTime = new TimeSelectorComponent("Ending time");
	private ZonedDateTime begin;
	private ZonedDateTime end;
	
	public CreateEventForm(Schedule schedule) {
		
		this.schedule = schedule;
		setSizeUndefined();
		date.setDateFormat("dd-MM-yyyy");
		date.setPlaceholder("dd-mm-yyyy");
		date.setRangeStart(LocalDate.now());
		
		
		addComponents(location, name, description, date, startingTime.getLayout(), endingTime.getLayout(), submit);
		content = new VerticalLayout();
		submit.setClickShortcut(KeyCode.ENTER);
		submit.addClickListener(e -> this.submit());
		
	}
	
	public VerticalLayout getLayout() {
		return content;
	}

	
	public void submit() {
		try {
			try {
			convertBegin();
			convertEnd();
			} catch (DateTimeParseException e) {
				Notification.show("Insert time");
			}
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			Notification.show("Insert a date");
		}
		Meeting meeting = new Meeting(false);
		try {
		meeting.setStart(begin);
		meeting.setEnd(end);
		
		meeting.setName(name.getValue());
		meeting.setLocation(location.getValue());
		meeting.setDetails(description.getValue());
		meeting.setState(State.planned);
		} catch (EmptyResultDataAccessException e) {
			Notification.show("Invalid data, insert something");
		}
		schedule.onSubmitEvent(meeting);
	}
	
	private void convertBegin() {
		LocalTime time = LocalTime.parse(startingTime.getHour()+":"+startingTime.getMinute());
		begin = ZonedDateTime.of(date.getValue(), time, ZonedDateTime.now().getZone());
		
	}
	
	private void convertEnd() {
		LocalTime time = LocalTime.parse(endingTime.getHour()+":"+endingTime.getMinute());
		if (time.isBefore(begin.toLocalTime())) {
			end = ZonedDateTime.of(date.getValue().plusDays(1), time, ZonedDateTime.now().getZone());
		}
		else {
			end = ZonedDateTime.of(date.getValue(), time, ZonedDateTime.now().getZone());
		}
		
		
	}
	
}
