package com.polimi.travlendar.ui.pages;

import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;

import org.springframework.beans.factory.annotation.Autowired;

import com.polimi.travlendar.User;
import com.polimi.travlendar.components.Schedule;
import com.polimi.travlendar.ui.CreateEventForm;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringView(name = SchedulePage.NAME)
public class SchedulePage extends VerticalLayout implements View {

	private Schedule schedule;

	public static final String NAME = "SchedulePage";

//	private CreateEventForm createEvent;

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		
		schedule = (Schedule)VaadinSession.getCurrent().getAttribute("schedule");
		ComboBox<Month> months = new ComboBox<>();
		months.setItems(Month.values());
		months.setItemCaptionGenerator(
				month -> month.getDisplayName(TextStyle.FULL, schedule.getCalendar().getLocale()));
		months.setEmptySelectionAllowed(false);
		months.addValueChangeListener(me -> schedule.switchToMonth(me.getValue()));
		Button today = new Button("today",
				(Button.ClickEvent clickEvent) -> schedule.getCalendar().withDay(ZonedDateTime.now()));
		Button week = new Button("week",
				(Button.ClickEvent clickEvent) -> schedule.getCalendar().withWeek(ZonedDateTime.now()));

		HorizontalLayout nav = new HorizontalLayout(months, today, week);
		this.addComponents(nav/*, createEvent*/);
		this.addComponent(schedule);

	}

}
