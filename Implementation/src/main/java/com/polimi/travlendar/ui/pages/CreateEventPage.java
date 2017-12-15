/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.ui.pages;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vaadin.data.Binder;
import com.vaadin.data.Binder.Binding;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.data.BindingValidationStatus;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.SerializablePredicate;
import com.vaadin.shared.Registration;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author jaycaves
 */
/*
@SuppressWarnings("serial")
@SpringView(name = CreateEventPage.NAME)
public class CreateEventPage extends VerticalLayout implements View {

    public static final String NAME = "Create Event";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        initForm();
    }

    private void initForm() {

        FormLayout layoutWithBinder = new FormLayout();
        Binder<Calendar_Event> binder = new Binder<>();

// The object that will be edited
        Calendar_Event newEvent = new Calendar_Event();

        //layoutWithBinder.setResponsiveSteps();

// Create the fields
        TextField startLocation = new TextField();
        TextField destinationLocation = new TextField();
        TextField phone = new TextField();
        TextField email = new TextField();
        DateField date= new DateField();
        Label infoLabel = new Label();
        Button save = new Button("Save");
        Button reset = new Button("Reset");

        layoutWithBinder.addComponents(startLocation,destinationLocation,phone, email,date);
        

// Button bar
        HorizontalLayout actions = new HorizontalLayout();
        actions.addComponent(save);
        actions.addComponent(reset);
        SerializablePredicate<String> phoneOrEmailPredicate = value -> !phone
                .getValue().trim().isEmpty()
                || !email.getValue().trim().isEmpty();

// E-mail and phone have specific validators
        Binding<Calendar_Event, String> emailBinding = binder.forField(email)
                .withValidator(phoneOrEmailPredicate,
                        "Both phone and email cannot be empty")
                .bind(Calendar_Event::getEmail, Calendar_Event::setEmail);

        Binding<Calendar_Event, String> phoneBinding = binder.forField(phone)
                .withValidator(phoneOrEmailPredicate,
                        "Both phone and email cannot be empty")
                .bind(Calendar_Event::getPhone, Calendar_Event::setPhone);

// Trigger cross-field validation when the other field is changed
        email.addValueChangeListener(event -> phoneBinding.validate());
        phone.addValueChangeListener(event -> emailBinding.validate());

// First name and last name are required fields
        startLocation.setRequiredIndicatorVisible(true);
        destinationLocation.setRequiredIndicatorVisible(true);

        binder.forField(startLocation)
                .withValidator(new StringLengthValidator(
                        "Please add the first name", 1, null))
                .bind(Calendar_Event::getStart, Calendar_Event::setStart);
        binder.forField(destinationLocation)
                .withValidator(new StringLengthValidator(
                        "Please add the last name", 1, null))
                .bind(Calendar_Event::getDest, Calendar_Event::setDest);

// Birthdate and doNotCall don't need any special validators
        //binder.bind(doNotCall, Calendar_Event::isDoNotCall, Calendar_Event::setDoNotCall);
        //binder.bind(date, Calendar_Event::getDate, Calendar_Event::setDate);
// Click listeners for the buttons
        Registration addClickListener = save.addClickListener((Button.ClickEvent event) -> {
            if (binder.writeBeanIfValid(newEvent)) {
                infoLabel.setValue("Saved bean values: " + newEvent);

            } else {
                BinderValidationStatus<Calendar_Event> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                infoLabel.setValue("There are errors: " + errorText);
            }
        });
        reset.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            infoLabel.setValue("");
            //doNotCall.setValue(false);
        });
    }

    private static class Calendar_Event {

        protected String email;
        
        protected String phone;
        
        protected String dest;
        
        protected String start;
        
        protected Date date;
        
        public String getEmail() {
                return email;
        }

        public void setEmail() {

        }

        public String getPhone() {
            return phone;
        }

        public void setPhone() {

        }

        public void setDest() {

        }

        public String getDest() {
            return dest;
        }

        public void setStart() {

        }

        public String getStart() {
            return start;
        }

        public void setDate() {

        }

        public Date getDate() {
            return date;
        }

    }

} */
