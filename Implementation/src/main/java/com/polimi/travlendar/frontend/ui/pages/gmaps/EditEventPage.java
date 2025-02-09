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
package com.polimi.travlendar.frontend.ui.pages.gmaps;

import com.polimi.travlendar.backend.model.events.Meeting;
import com.polimi.travlendar.frontend.ui.forms.EventForm;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Paolo
 */
@SuppressWarnings("serial")
@SpringView(name = EditEventPage.NAME)
public class EditEventPage extends VerticalLayout implements View {

    public static final String NAME = "EditEventPage";
    @Autowired
    private EventForm createEvent;

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        createEvent.setEdit((Meeting) VaadinSession.getCurrent().getAttribute("editableMeeting"));
        addComponent(createEvent);
    }

}
