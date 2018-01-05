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
package com.polimi.travlendar.gmaps;

import com.google.maps.model.DirectionsResult;
import com.google.maps.model.PlacesSearchResult;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Marco
 */
public class LocationForm extends HorizontalLayout implements PlaceSearchFieldClient{
    
    VaadinMap map;
    
    PlaceSearchField start;
    PlaceSearchField end;
    
    PlacesSearchResult startPlace;
    PlacesSearchResult endPlace;
    
    DirectionsResult directions;
    Label directionsLabel;
    
    GoogleMapsService service;
    
    public LocationForm(){
        service = new GoogleMapsService();
        VerticalLayout sideBar = new VerticalLayout();
        start = new PlaceSearchField();
        end = new PlaceSearchField();
        start.setPlaceHolder("Start...");
        end.setPlaceHolder("End...");
        start.registerClient(this);
        end.registerClient(this);
        sideBar.addComponents(start, end);
        map = new VaadinMap();
        Panel directionsPanel = new Panel("Directions");
        directionsLabel = new Label("", ContentMode.PREFORMATTED);
        directionsPanel.setContent(directionsLabel);
        directionsPanel.setHeight("100%");
        this.addComponents(sideBar, map, directionsPanel);
        this.setSizeFull();
        this.setExpandRatio(sideBar, 1);
        this.setExpandRatio(map, 2);
        this.setExpandRatio(directionsPanel, 1);
    }

    @Override
    public void deliverPlace(PlaceSearchField caller, PlacesSearchResult result) {
        if(caller == start){
            startPlace = result;
            map.setMarker(startPlace, 1);
        }
        if(caller == end){
            endPlace = result;
            map.setMarker(endPlace, 2);
        }
        getDirections();
    }

    @Override
    public void resultNotFoundError() {
        Notification.show("Result not found", Type.WARNING_MESSAGE);
    }
    
        private void getDirections() {
        if (startPlace != null && endPlace != null) {
            DirectionsResult result = null;
            try {
                result = service.calculateDirections(startPlace, endPlace);
            } catch (ResultNotFoundException re) {
                Notification.show(re.directionsMessage, Type.WARNING_MESSAGE);
            } catch (Exception e) {
                Notification.show("Internal error with Google Maps. Please reload the page.", Type.ERROR_MESSAGE);
            } finally {
                if (result != null) {
                    String labelResult = service.directionsDescription(result);
                    directionsLabel.setValue(labelResult);
                    map.addPolyline(result);
                } else {
                    directionsLabel.setValue("No directions found");
                }
            }
        }
    }
}
