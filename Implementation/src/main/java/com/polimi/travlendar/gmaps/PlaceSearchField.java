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

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;
import se.walkercrou.places.exception.GooglePlacesException;

/**
 *
 * @author Marco
 */
public class PlaceSearchField extends VerticalLayout{
    
    private static final String KEY = "AIzaSyDGsAnfiLGU5WG2Yh7_glDJrRYvDnkGsSg";
    
    private Label place;
    private TextField searchTextField;
    private Button searchButton;
    
    public PlaceSearchField(){
        place = new Label("No place searched.");
        
        searchTextField = new TextField();
        searchTextField.setPlaceholder("Search...");
        
        searchButton = new Button(VaadinIcons.SEARCH);
        
        HorizontalLayout searchBar = new HorizontalLayout();
        searchBar.addComponents(searchTextField, searchButton);
        searchBar.setSpacing(false);
        
        this.addComponents(place, searchBar);
    }
    
    public Place searchPlace() throws GooglePlacesException{
        String text = searchTextField.getValue();
        if (text == null || text.equals("")) {
            searchTextField.setComponentError(new UserError("This field cannot be empty"));
        } else {
            try {
                List<Place> results;
                GooglePlaces client = new GooglePlaces(KEY);
                results = client.getPlacesByQuery(text, GooglePlaces.MAXIMUM_RESULTS);
                place.setValue(results.get(0).getName());
                return results.get(0);
            } catch (GooglePlacesException e) {
                throw e;
            }
        }
        return null;
    }
    
    public void setPlaceHolder(String text){
        searchTextField.setPlaceholder(text);
    }
    
    public void setClickListener(Button.ClickListener listener){
        searchButton.addClickListener(listener);
    }
    
}
