/*
 * Copyright 2017 Pivotal Software, Inc..
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
package com.polimi.travlendar.gmaps;

import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.PlacesSearchResult;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Marco
 */
public class PlaceSearchField extends VerticalLayout implements AutocompleteClient, PlaceSearchFieldClient, SelectionListener {

    GoogleMapsService service;

    PlaceSearchFieldClient client;

    private final Label place;
    private final TextField searchTextField;
    private final Button searchButton;

    private DynamicList predictionsList;

    public PlaceSearchField() {
        service = new GoogleMapsService();
        
        client = this;

        place = new Label("No place searched.");

        searchTextField = new TextField();
        searchTextField.setPlaceholder("Search...");

        searchButton = new Button(VaadinIcons.SEARCH);
        searchButton.addClickListener(e -> searchPlace());

        HorizontalLayout searchBar = new HorizontalLayout();
        searchBar.addComponents(searchTextField, searchButton);
        searchBar.setSpacing(false);

        predictionsList = new DynamicList(this, 5, new PredictionCaptionGenerator());

        searchTextField.setValueChangeMode(ValueChangeMode.LAZY);
        searchTextField.addValueChangeListener(e -> {
            service.predict(this, searchTextField.getValue());
        });

        this.addComponents(place, searchBar/*, predictionsList*/);
    }

    public void registerClient(PlaceSearchFieldClient newClient) {
        client = newClient;
    }

    public void searchPlace() {
        String text = searchTextField.getValue();
        if (text == null || text.equals("")) {
            searchTextField.setComponentError(new UserError("This field cannot be empty"));
        } else {
            try {
                PlacesSearchResult result = service.searchPlace(text);
                place.setValue(result.name);
                client.deliverPlace(this, result);
            } catch (ResultNotFoundException re) {
                client.resultNotFoundError();
            } catch (Exception e) {
                searchTextField.setValue("Internal error.");
                e.printStackTrace();
            }
        }
    }

    public void setPlaceHolder(String text) {
        searchTextField.setPlaceholder(text);
    }

    // AutocompleteClient methods: to recieve ashyncronous predictions by GoogleMapsService
    @Override
    public void deliverPredictions(AutocompletePrediction[] predictions) {
        System.out.println("Place search field: updating predictions...");
        List<Object> list = new ArrayList<Object>();
        for (AutocompletePrediction p : predictions) {
            list.add(p);
        }
        predictionsList.setList(list);
    }

    @Override
    public void predictionError() {
        Notification.show("Internal error with Google Maps.", Type.ERROR_MESSAGE);
    }

    // Default PlaceSearchFieldClient methods to use if no client has been registered
    @Override
    public void deliverPlace(PlaceSearchField caller, PlacesSearchResult result) {
        Notification.show("Result found!");
    }

    @Override
    public void resultNotFoundError() {
        Notification.show("Result not found.", Type.WARNING_MESSAGE);
    }

    // Method to catch user selection from DynamicList of predictions
    @Override
    public void listen(Object selection) {
        AutocompletePrediction prediction = (AutocompletePrediction) selection;
        searchTextField.setValue(prediction.description);
        searchPlace();
    }

    //
}
