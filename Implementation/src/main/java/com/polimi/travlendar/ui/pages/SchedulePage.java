package com.polimi.travlendar.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;

import com.polimi.travlendar.components.Schedule;
import com.vaadin.icons.VaadinIcons;
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
@MenuIcon(VaadinIcons.CALENDAR)
public class SchedulePage extends VerticalLayout implements View {
    
    private Schedule schedule;

    public static final String NAME = "SchedulePage";

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
        Button month = new Button("month",
                (Button.ClickEvent clickEvent) -> schedule.getCalendar().withMonth(ZonedDateTime.now().getMonth()));
        HorizontalLayout nav = new HorizontalLayout(months, today, week, month);
        this.addComponents(nav);
        this.addComponent(schedule);

    }
    
    

}
