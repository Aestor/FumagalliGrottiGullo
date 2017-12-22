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

import com.google.maps.model.PlacesSearchResult;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.UserError;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Marco
 */
@SpringComponent
@Scope("prototype")
public class PlaceSearchField extends VerticalLayout{

    @Autowired
    GoogleMapsService service;

    private final Label place;
    private final TextField searchTextField;
    private final Button searchButton;

    public PlaceSearchField() {
        place = new Label("No place searched.");

        searchTextField = new TextField();
        searchTextField.setPlaceholder("Search...");

        searchButton = new Button(VaadinIcons.SEARCH);

        HorizontalLayout searchBar = new HorizontalLayout();
        searchBar.addComponents(searchTextField, searchButton);
        searchBar.setSpacing(false);

        this.addComponents(place, searchBar);
    }

    public PlacesSearchResult searchPlace() throws ResultNotFoundException {
        String text = searchTextField.getValue();
        if (text == null || text.equals("")) {
            searchTextField.setComponentError(new UserError("This field cannot be empty"));
        } else {
            try {
                return service.searchPlace(text);
            } catch (ResultNotFoundException re) {
                throw re;
            } catch (Exception e) {
                searchTextField.setValue("Internal error.");
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setPlaceHolder(String text) {
        searchTextField.setPlaceholder(text);
    }

    public void setClickListener(Button.ClickListener listener) {
        searchButton.addClickListener(listener);
    }

}
