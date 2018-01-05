/*
 * Copyright 2018 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.polimi.travlendar.frontend.ui.forms;

import com.polimi.travlendar.backend.beans.UserService;
import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.model.user.UserSettings;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.UserError;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Form where user can modify his preferences and update his account.
 *
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringComponent
@Scope("session")
public class UpdateAccountForm extends HorizontalLayout implements View {

    @Autowired
    UserService service;

    @Autowired
    User user;

    private final Label head;
    private final Label middle;
    private TextField name;
    private TextField lastname;
    private PasswordField password;
    private PasswordField confirm;
    private Button submit;
    private boolean confirmation;
    private CheckBox licence;
    private CheckBox mycar;
    private CheckBox mybike;
    private TextField maxWalking;
    private RadioButtonGroup<String> carPreference;
    private RadioButtonGroup<String> bikePreference;
    private Button update;
    private UserSettings currentUserSettings;

    public UpdateAccountForm() {

        this.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        VerticalLayout preferences = new VerticalLayout();
        head = new Label("MY PREFERENCES:");
        head.setStyleName("mytitle");
        licence = new CheckBox("I have a valid driving licence");
        mycar = new CheckBox("I own a car");
        mybike = new CheckBox("I own a bike");
        maxWalking = new TextField("Max kilometers by walking per day: ");
        maxWalking.setMaxLength(3);
        maxWalking.addValueChangeListener(e -> this.checkInt());
        carPreference = new RadioButtonGroup<>("Car Preference: ");
        bikePreference = new RadioButtonGroup<>("Bike Preference:");
        carPreference.setItems(PreferenceLevel.getAsList());
        bikePreference.setItems(PreferenceLevel.getAsList());
        update = new Button("Update", VaadinIcons.CHECK);
        update.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        update.addClickListener(e -> this.updatePreferences());
        preferences.addComponents(head, licence, mycar, mybike, maxWalking, carPreference, bikePreference, update);
        VerticalLayout empty = new VerticalLayout();
        empty.setHeight("300px");
        empty.setWidth("300px");
        VerticalLayout account = new VerticalLayout();
        middle = new Label("MY ACCOUNT:");
        middle.setStyleName("mytitle");
        name = new TextField("Name: ");
        lastname = new TextField("Surname: ");
        password = new PasswordField("Password");
        confirm = new PasswordField("Confirm password");
        submit = new Button("Submit", VaadinIcons.CHECK);
        setSizeUndefined();
        account.addComponents(middle, name, lastname, password, confirm, submit);
        submit.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        submit.addClickListener(e -> this.updateAccount());
        confirm.addBlurListener(e -> this.checkConfirm());
        addComponents(preferences, empty, account);
    }

    private void checkConfirm() {
        if (password.isEmpty() || confirm.isEmpty() || !password.getValue().equals(confirm.getValue())) {
            confirm.setComponentError(new UserError("The passwords must be the same"));
            confirmation = false;
        } else {
            confirm.setComponentError(null);
            confirmation = true;
        }
    }

    private void updateAccount() {
        user.setFirst_name(name.getValue());
        user.setLast_name(lastname.getValue());
        user.setPassword(password.getValue());
        service.updateUser(user);
        Notification.show("Account Updated!");
    }

    private void updatePreferences() {
        
        service.updatePreferences(new UserSettings(PreferenceLevel.valueOf(bikePreference.getValue().toUpperCase()),
                PreferenceLevel.valueOf(carPreference.getValue().toUpperCase()), Integer.parseInt(maxWalking.getValue()),
                mycar.getValue(), mybike.getValue(), licence.getValue()), user.getId());
        Notification.show("Preferences Updated!");
    }

    private void checkInt() {

        try {

            int value = Integer.parseInt(this.maxWalking.getValue());

        } catch (NumberFormatException e) {
            Notification.show("Error: Inserted value is not valid", Notification.Type.ERROR_MESSAGE);
            maxWalking.setValue("");
        }

    }

    /**
     * Fetches all preferences from database and shows them in the form.
     */
    public void init() {

        currentUserSettings = service.getPreferences(user.getId());

        licence.setValue(currentUserSettings.isDrivingLicense());
        mycar.setValue(currentUserSettings.isCarAvailability());
        mybike.setValue(currentUserSettings.isBikeAvailability());
        carPreference.setValue(currentUserSettings.getCarPreference().getPreference());
        bikePreference.setValue(currentUserSettings.getBikePreference().getPreference());
        name.setValue(user.getFirst_name());
        lastname.setValue(user.getLast_name());
        password.setValue(user.getPassword());
        confirm.setValue(user.getPassword());
        maxWalking.setValue(String.valueOf(currentUserSettings.getMaxWalkingDistance()));
    }
}
