package com.polimi.travlendar.frontend.ui.forms;

import com.polimi.travlendar.backend.beans.EventService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.dao.EmptyResultDataAccessException;

import com.polimi.travlendar.backend.model.events.Meeting;
import com.polimi.travlendar.backend.model.events.Meeting.State;
import com.polimi.travlendar.backend.model.events.Schedule;
import com.polimi.travlendar.backend.model.events.TimeSelectorComponent;
import com.polimi.travlendar.backend.model.user.PreferenceLevel;
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
public class EventForm extends FormLayout {

    @Autowired
    private EventService service;
    @Autowired
    private Schedule schedule;

    private TextField location = new TextField("Location");
    private TextField name = new TextField("Event");
    private TextField description = new TextField("Description");
    private DateField dateStart = new DateField("Start");
    private DateField dateEnd = new DateField("End");
    private Button submit = new Button("Submit");
    private Button reset = new Button("Reset");
    private long id;

    private VerticalLayout content;
    private TimeSelectorComponent startingTime = new TimeSelectorComponent("Starting time");
    private TimeSelectorComponent endingTime = new TimeSelectorComponent("Ending time");
    private ZonedDateTime begin;
    private ZonedDateTime end;
    private ComboBox<PreferenceLevel> preference;
    protected boolean eventOk = true;
    protected boolean wait = false;

    private HorizontalLayout submitReset = new HorizontalLayout();

    /**
     * Constructor to create a new event.
     */
    public EventForm() {
        setSizeUndefined();
        schedule = (Schedule) VaadinSession.getCurrent().getAttribute("schedule");
        dateStart.setDateFormat("dd-MM-yyyy");
        dateStart.setPlaceholder("dd-mm-yyyy");
        dateStart.setRangeStart(LocalDate.now());
        dateEnd.setDateFormat("dd-MM-yyyy");
        dateEnd.setPlaceholder("dd-mm-yyyy");
        dateEnd.setEnabled(false);
        endingTime.setEnabled(false);
        dateStart.addValueChangeListener(e -> {
            dateEnd.setEnabled(true);
            dateEnd.setRangeStart(dateStart.getValue());
            endingTime.setEnabled(true);
        });

        setComboBox();
        HorizontalLayout submitReset = new HorizontalLayout();
        submitReset.addComponents(submit, reset);
        addComponents(location, name, description, dateStart, startingTime.getLayout(), dateEnd, endingTime.getLayout(), preference, submitReset);
        content = new VerticalLayout();
        submit.setClickShortcut(KeyCode.ENTER);
        submit.addClickListener(e -> this.submit());
        reset.addClickListener(e -> this.reset());

    }

    /**
     * Method to setup the edit form.
     *
     * @param meeting the event to edit.
     */
    public void setEdit(Meeting meeting) {
        dateEnd.setEnabled(true);
        endingTime.setEnabled(true);
        dateStart.setDateFormat("dd-MM-yyyy");
        dateStart.setRangeStart(LocalDate.now());
        location.setValue(meeting.getLocation());
        name.setValue(meeting.getName());
        description.setValue(meeting.getDetails());
        dateStart.setValue(meeting.getStart().toLocalDate());
        dateEnd.setValue(meeting.getEnd().toLocalDate());
        startingTime.setHour(meeting.getStart().toLocalTime().getHour());
        startingTime.setMinute(meeting.getStart().toLocalTime().getMinute());
        endingTime.setHour(meeting.getEnd().toLocalTime().getHour());
        endingTime.setMinute(meeting.getEnd().toLocalTime().getMinute());
        preference.setValue(meeting.getPreferenceLevel());
        submitReset.removeAllComponents();
        HorizontalLayout editCancel = new HorizontalLayout();
        Button edit = new Button("Edit");
        Button cancel = new Button("Cancel");
        editCancel.addComponents(edit, cancel);
        addComponent(editCancel);
        Meeting m = new Meeting(false);
        convertBegin();
        convertEnd();
        m.setUser(schedule.getUser().getId());
        m.setStart(begin);
        m.setEnd(end);
        m.setName(name.getValue());
        m.setLocation(location.getValue());
        m.setDetails(description.getValue());
        m.setPreferenceLevel(preference.getValue());
        m.setState(State.planned);
        m.setId(meeting.getId());
        edit.addClickListener(e -> this.edit(m));
        cancel.addClickListener(e -> this.cancel());

    }

    public void cancel() {
        UI.getCurrent().getNavigator().navigateTo("");

    }

    public void edit(Meeting m) {

        try {

            convertBegin();
            convertEnd();
            Meeting meeting = new Meeting(false);
            meeting.setId(m.getId());
            meeting.setUser(schedule.getUser().getId());
            meeting.setStart(begin);
            meeting.setEnd(end);
            meeting.setName(name.getValue());
            meeting.setLocation(location.getValue());
            meeting.setDetails(description.getValue());
            meeting.setPreferenceLevel(preference.getValue());
            meeting.setState(State.planned);
            if (begin.isBefore(end)) {
               service.editMeeting(meeting);
            } else {
                Notification.show("Select a valid time");
            }

        } catch (NullPointerException | DateTimeParseException | EmptyResultDataAccessException e) {
            // TODO Auto-generated catch block
            Notification.show(error());
        }
        // TODO Auto-generated catch block

    }

    private void setComboBox() {
        preference = new ComboBox<>("Event Priority");
        preference.setItems(PreferenceLevel.values());
        preference.setEmptySelectionAllowed(false);
        preference.setPlaceholder("HIGH");
    }

    public VerticalLayout getLayout() {
        return content;
    }

    public void submit() {

        try {

            convertBegin();
            convertEnd();
            Meeting meeting = new Meeting(false);
            meeting.setUser(schedule.getUser().getId());
            meeting.setStart(begin);
            meeting.setEnd(end);
            meeting.setName(name.getValue());
            meeting.setLocation(location.getValue());
            meeting.setDetails(description.getValue());
            meeting.setPreferenceLevel(preference.getValue());
            meeting.setState(State.planned);
            if (begin.isBefore(end)) {
                CreateEventRecap recap = new CreateEventRecap(meeting);
                UI.getCurrent().addWindow(recap);
            } else {
                Notification.show("Select a valid time");
            }

        } catch (NullPointerException | DateTimeParseException | EmptyResultDataAccessException e) {
            // TODO Auto-generated catch block
            Notification.show(error());
        }
        // TODO Auto-generated catch block

    }

    public void createEvent() {

    }

    public void reset() {
        location.clear();
        name.clear();
        description.clear();
        dateStart.clear();
        startingTime.clear();
        endingTime.clear();

    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    private void convertBegin() {
        LocalTime time = LocalTime.parse(startingTime.getHour() + ":" + startingTime.getMinute());
        begin = ZonedDateTime.of(dateStart.getValue(), time, ZonedDateTime.now().getZone());

    }

    private void convertEnd() {
        LocalTime time = LocalTime.parse(endingTime.getHour() + ":" + endingTime.getMinute());
        end = ZonedDateTime.of(dateEnd.getValue(), time, ZonedDateTime.now().getZone());
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

                Notification.show("Event created successfully");
                schedule.onSubmitEvent(form);
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
    }

}
