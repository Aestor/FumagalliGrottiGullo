package com.polimi.travlendar.ui;

import com.polimi.travlendar.EventService;
import com.polimi.travlendar.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.dao.EmptyResultDataAccessException;

import com.polimi.travlendar.components.Meeting;
import com.polimi.travlendar.components.Meeting.State;
import com.polimi.travlendar.components.Schedule;
import com.polimi.travlendar.components.TimeSelectorComponent;
import com.polimi.travlendar.user.PreferenceLevel;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@SpringComponent
@Scope("prototype")
public class CreateEventForm extends FormLayout {
    
    @Autowired
    private EventService service;

    
    private TextField location = new TextField("Location");
    private TextField name = new TextField("Event");
    private TextField description = new TextField("Description");
    private DateField date = new DateField("Date");
    private Button submit = new Button("Submit");
    private Button reset = new Button("Reset");
    private Schedule schedule;
    private VerticalLayout content;
    private TimeSelectorComponent startingTime = new TimeSelectorComponent("Starting time");
    private TimeSelectorComponent endingTime = new TimeSelectorComponent("Ending time");
    private ZonedDateTime begin;
    private ZonedDateTime end;
    private ComboBox<PreferenceLevel> preference;
    protected boolean eventOk = true;
    protected boolean wait = false;

    public CreateEventForm() {
        setSizeUndefined();
        date.setDateFormat("dd-MM-yyyy");
        date.setPlaceholder("dd-mm-yyyy");
        date.setRangeStart(LocalDate.now());
        setComboBox();
        HorizontalLayout submitReset = new HorizontalLayout();
        submitReset.addComponents(submit, reset);
        addComponents(location, name, description, date, startingTime.getLayout(), endingTime.getLayout(), preference, submitReset);
        content = new VerticalLayout();
        submit.setClickShortcut(KeyCode.ENTER);
        submit.addClickListener(e -> this.submit());
        reset.addClickListener(e -> this.reset());

    }
    
    private void setComboBox() {
        preference = new ComboBox<>("Event Priority");
        preference.setItems(PreferenceLevel.values());
        preference.setEmptySelectionAllowed(false);
    }

    public VerticalLayout getLayout() {
        return content;
    }

    public void submit() {

        try {
            convertBegin();
            convertEnd();

            Meeting meeting = new Meeting(false);
            meeting.setUser(schedule.getUser());
            meeting.setStart(begin);
            meeting.setEnd(end);

            meeting.setName(name.getValue());
            meeting.setLocation(location.getValue());
            meeting.setDetails(description.getValue());
            meeting.setPreferenceLevel(preference.getValue());
            meeting.setState(State.planned);
            CreateEventRecap recap = new CreateEventRecap(meeting);
            UI.getCurrent().addWindow(recap);

        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            Notification.show(error());
        } catch (DateTimeParseException e) {
            Notification.show(error());

        } catch (EmptyResultDataAccessException e) {
            // TODO Auto-generated catch block
            Notification.show(error());
        }
    }

    public void createEvent() {

    }

    public void reset() {
        location.clear();
        name.clear();
        description.clear();
        date.clear();
        startingTime.clear();
        endingTime.clear();

    }
    
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    private void convertBegin() {
        LocalTime time = LocalTime.parse(startingTime.getHour() + ":" + startingTime.getMinute());
        begin = ZonedDateTime.of(date.getValue(), time, ZonedDateTime.now().getZone());

    }

    private void convertEnd() {
        LocalTime time = LocalTime.parse(endingTime.getHour() + ":" + endingTime.getMinute());
        if (time.isBefore(begin.toLocalTime())) {
            end = ZonedDateTime.of(date.getValue().plusDays(1), time, ZonedDateTime.now().getZone());
        } else {
            end = ZonedDateTime.of(date.getValue(), time, ZonedDateTime.now().getZone());
        }

    }

    public String getLocation() {
        try {
            return location.getValue();
        } catch (NullPointerException e) {
            return "Invalid input";
        }
    }

    public String getDescription() {
        try {
            return description.getValue();
        } catch (NullPointerException e) {
            return "Invalid input";
        }
    }

    public String getName() {
        try {
            return name.getValue();
        } catch (NullPointerException e) {
            return "Invalid input";
        }
    }

    public String getBeginTimeToString() {
        return begin.toLocalTime().toString();
    }

    public String getEndTimeToString() {
        return end.toLocalTime().toString();
    }

    public String getDateToString() {
        return begin.toLocalDate().toString();
    }

    private String error() {
        return "Insert valid data";
    }

    private class CreateEventRecap extends Window {

        public CreateEventRecap(Meeting form) {
            super("Recap");
            setModal(true);
            center();

            setClosable(false);
            Button ok = new Button("OK", e -> {
                schedule.onSubmitEvent(form);
                Notification.show("Event created successfully");
                saveEvent(form);
                close();
            });
            Button no = new Button("NO", e -> {
                Notification.show("Event not created");
                close();
            });
            VerticalLayout layout = new VerticalLayout();
            TextArea area = new TextArea();
            area.setValue("Event Recap:\n" + "Location: " + form.getLocation() + "\nEvent: " + form.getName()
                    + "\nDescription: " + form.getDetails() + "\nDate: " + form.getStart().toLocalDate().toString()
                    + "\nFrom: " + form.getStart().toLocalTime().toString() + " to "
                    + form.getEnd().toLocalTime().toString());
            area.setWidth("300px");
            area.setHeight("300px");
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.addComponents(ok, no);
            layout.addComponents(area, buttons);
            setContent(layout);
        }

        public boolean getEventOk() {
            return eventOk;
        }

    }
    
    public void saveEvent(Meeting meeting) {
        try {
            service.addMeeting(meeting);
        } catch (EmptyResultDataAccessException e) {
            Notification.show("Internal error!", Type.ERROR_MESSAGE);
        }
      /*  catch (NullPointerException e) {
            Notification.show("NON FUNZIONA 'NA MAZZA", Type.ERROR_MESSAGE);
        }*/
    }

}
