package com.polimi.travlendar.backend.model.events;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.time.LocalDate;

public class TimeSelectorComponent extends CustomComponent {

    private List<String> hour = new ArrayList<>();
    private List<String> minute = new ArrayList<>();
    private ComboBox<String> hours = new ComboBox<>();
    private ComboBox<String> minutes = new ComboBox<>();
    private Label caption;
    private final HorizontalLayout layout = new HorizontalLayout();
    private final VerticalLayout layout2 = new VerticalLayout();

    public TimeSelectorComponent(String caption) {
        this.caption = new Label(caption);

        hour.add("00");
        hour.add("01");
        hour.add("02");
        hour.add("03");
        hour.add("04");
        hour.add("05");
        hour.add("06");
        hour.add("07");
        hour.add("08");
        hour.add("09");
        hour.add("10");
        hour.add("11");
        hour.add("12");
        hour.add("13");
        hour.add("14");
        hour.add("15");
        hour.add("16");
        hour.add("17");
        hour.add("18");
        hour.add("19");
        hour.add("20");
        hour.add("21");
        hour.add("22");
        hour.add("23");

        minute.add("00");
        minute.add("01");
        minute.add("02");
        minute.add("03");
        minute.add("04");
        minute.add("05");
        minute.add("06");
        minute.add("07");
        minute.add("08");
        minute.add("09");
        minute.add("10");
        minute.add("11");
        minute.add("12");
        minute.add("13");
        minute.add("14");
        minute.add("15");
        minute.add("16");
        minute.add("17");
        minute.add("18");
        minute.add("19");
        minute.add("20");
        minute.add("21");
        minute.add("22");
        minute.add("23");
        minute.add("24");
        minute.add("25");
        minute.add("26");
        minute.add("27");
        minute.add("28");
        minute.add("29");
        minute.add("30");
        minute.add("31");
        minute.add("32");
        minute.add("33");
        minute.add("34");
        minute.add("35");
        minute.add("36");
        minute.add("37");
        minute.add("38");
        minute.add("39");
        minute.add("40");
        minute.add("41");
        minute.add("42");
        minute.add("43");
        minute.add("44");
        minute.add("45");
        minute.add("46");
        minute.add("47");
        minute.add("48");
        minute.add("49");
        minute.add("50");
        minute.add("51");
        minute.add("52");
        minute.add("53");
        minute.add("54");
        minute.add("55");
        minute.add("56");
        minute.add("57");
        minute.add("58");
        minute.add("59");

        hours.setItems(hour);
        minutes.setItems(minute);
        hours.setWidth("86.5px");
        minutes.setWidth("86.5px");
        hours.setPlaceholder("HH");
        minutes.setPlaceholder("mm");
        hours.setEmptySelectionAllowed(false);
        minutes.setEmptySelectionAllowed(false);
        layout.addComponents(hours, minutes);
        layout2.addComponents(this.caption, layout);

    }

    public HorizontalLayout getLayout() {
        return layout;
    }

    public VerticalLayout getLayout2() {
        return layout2;
    }

    public String getHour() {
        return hours.getValue();
    }

    public String getMinute() {
        return minutes.getValue();
    }

    public void clear() {
        hours.clear();
        minutes.clear();
    }

    public void setHour(int hour) {
        try {
            if (hour > 9) {
                hours.setValue(String.valueOf(hour));
            } else {
                hours.setValue("0" + String.valueOf(hour));
            }
        } catch (NullPointerException e) {
            Notification.show("Internal error", Notification.Type.ERROR_MESSAGE);
        }
    }

    public void setMinute(int minute) {
        try {
            if (minute > 9) {
                minutes.setValue(String.valueOf(minute));
            } else {
                minutes.setValue("0"+String.valueOf(minute));
            }
        } catch (NullPointerException e) {
            Notification.show("Internal error", Notification.Type.ERROR_MESSAGE);
        }
    }

}
