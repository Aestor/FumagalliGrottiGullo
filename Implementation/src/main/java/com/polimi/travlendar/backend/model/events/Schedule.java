package com.polimi.travlendar.backend.model.events;

import com.polimi.travlendar.backend.beans.EventService;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import org.springframework.context.annotation.Scope;
import org.vaadin.addon.calendar.Calendar;
import org.vaadin.addon.calendar.handler.BasicDateClickHandler;
import org.vaadin.addon.calendar.item.BasicItemProvider;
import org.vaadin.addon.calendar.ui.CalendarComponentEvents;

import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.frontend.ui.forms.EventForm;
import com.polimi.travlendar.frontend.ui.pages.gmaps.EditEventPage;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@VaadinSessionScope
@SuppressWarnings("serial")
@Scope("session")
/**
 * This class creates the Calendar component of the application.
 *
 * @Author Aestor
 */
public class Schedule extends CustomComponent {

    private MeetingDataProvider eventProvider;

    private Calendar<MeetingItem> calendar;

    public Panel panel;

    @Autowired
    private User user;

    @Autowired
    private EventService eService;

    public Schedule() {
        setId("schedule");
        setSizeFull();
        initCalendar();

        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(false);
        layout.setSpacing(false);
        layout.setSizeFull();

        panel = new Panel(calendar);
        panel.setHeight(100, Unit.PERCENTAGE);
        //layout.addComponent(new Label("Calendar of: " + user.getFirst_name() + " " + user.getLast_name()));
        layout.addComponent(panel);

        setCompositionRoot(layout);
    }

    /**
     * switches the view of the calendar to the selected month.
     *
     * @param month the selected month.
     */
    public void switchToMonth(Month month) {
        calendar.withMonth(month);
    }

    public Calendar<MeetingItem> getCalendar() {
        return calendar;
    }

    /**
     * method called whenever a user clicks on an event present in the calendar.
     *
     * @param event
     */
    private void onCalendarClick(CalendarComponentEvents.ItemClickEvent event) {
        MeetingItem item = (MeetingItem) event.getCalendarItem();

        final Meeting meeting = item.getMeeting();

        Edit edit = new Edit(meeting, this);
        UI.getCurrent().addWindow(edit);
    }

    /**
     * Initializes the calendar from a UI point of view.
     */
    private void initCalendar() {
        eventProvider = new MeetingDataProvider();

        calendar = new Calendar<>(eventProvider);

        calendar.addStyleName("meetings");
        calendar.setWidth(100.0f, Unit.PERCENTAGE);
        calendar.setHeight(100.0f, Unit.PERCENTAGE);
        calendar.setResponsive(true);

        calendar.setItemCaptionAsHtml(true);
        calendar.setContentMode(ContentMode.HTML);

        calendar.withVisibleDays(1, 7);

        calendar.withMonth(ZonedDateTime.now().getMonth());

        addCalendarEventListeners();

        setupBlockedTimeSlots();

    }

    /**
     * sets up the time slots of the calendar.
     */
    private void setupBlockedTimeSlots() {

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
        cal.clear(java.util.Calendar.MINUTE);
        cal.clear(java.util.Calendar.SECOND);
        cal.clear(java.util.Calendar.MILLISECOND);

        GregorianCalendar bcal = new GregorianCalendar(UI.getCurrent().getLocale());
        bcal.clear();

        long start = bcal.getTimeInMillis();

        bcal.add(java.util.Calendar.HOUR, 7);
        bcal.add(java.util.Calendar.MINUTE, 30);
        start = bcal.getTimeInMillis();

        long end = bcal.getTimeInMillis();
        calendar.addTimeBlock(start, end, "my-blocky-style");

        cal.add(java.util.Calendar.DAY_OF_WEEK, 1);

        bcal.clear();
        bcal.add(java.util.Calendar.HOUR, 14);
        bcal.add(java.util.Calendar.MINUTE, 30);
        start = bcal.getTimeInMillis();

        bcal.add(java.util.Calendar.MINUTE, 60);
        end = bcal.getTimeInMillis();

        calendar.addTimeBlock(start, end);
    }

    /**
     * Adds listeners to the calendar.
     */
    private void addCalendarEventListeners() {
        calendar.setHandler(new BasicDateClickHandler(true));
        calendar.setHandler(this::onCalendarClick);
    }

    /**
     * Handles the addition and removal of events.
     */
    private final class MeetingDataProvider extends BasicItemProvider<MeetingItem> {

        /**
         * Removes all the events from the calendar.
         */
        void removeAllEvents() {
            this.itemList.clear();
            fireItemSetChanged();
        }

        /**
         * Removes a single event from the calendar.
         *
         * @param meeting the event to be removed.
         */
        void removeEvent(Meeting meeting) {
            this.removeItem(new MeetingItem(meeting));
        }

    }

    /**
     * Adds an event to the calendar.
     *
     * @param meeting the event to be added.
     */
    public void onSubmitEvent(Meeting meeting) {
        eventProvider.addItem(new MeetingItem(meeting));
    }

    public User getUser() {
        return user;
    }

    /**
     * Removes all the events through the event provider.
     */
    public void removeAll() {
        eventProvider.removeAllEvents();
    }

    /**
     * removes a single event through the event provider.
     *
     * @param meeting the event to be removed.
     */
    public void removeEvent(Meeting meeting) {
        eventProvider.removeEvent(meeting);
    }

    /**
     * This private class is a UI component that is needed for the deletion and
     * editing of events.
     */
    private class Edit extends Window {

        @Autowired
        EventService service;
        Schedule schedule;

        public Edit(Meeting meeting, Schedule schedule) {
            super("Edit");
            this.schedule = schedule;
            Button edit = new Button("Edit");
            Button delete = new Button("Delete");
            setModal(true);
            center();
            setClosable(true);
            edit.addClickListener(e -> {
                edit(meeting);
                close();
            });
            delete.addClickListener(e -> {
                delete(meeting);
                close();
            });
            VerticalLayout layout = new VerticalLayout();
            layout.addComponents(edit, delete);
            setContent(layout);

        }

    }

    /**
     * This method is called inside the window Edit. It calls a new page and
     * sends the information about the event to the new page.
     *
     * @param meeting the meeting that will be edited.
     */
    public void edit(Meeting meeting) {
        VaadinSession.getCurrent().setAttribute("editableMeeting", meeting);
        UI.getCurrent().getNavigator().navigateTo(EditEventPage.NAME);
    }

    /**
     * This method is called inside the window Edit. It deletes the event by
     * deleting it from the calendar and from the database.
     *
     * @param meeting the event to be deleted.
     */
    public void delete(Meeting meeting) {
        eService.deleteMeeting(meeting);
        removeEvent(meeting);
    }
}
