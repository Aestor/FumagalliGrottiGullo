package com.polimi.travlendar.ui.pages.gmaps;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.google.maps.model.DirectionsResult;
import com.polimi.travlendar.gmaps.MapsDirections;
import com.polimi.travlendar.gmaps.PlaceSearchField;
import com.polimi.travlendar.gmaps.VaadinMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

import se.walkercrou.places.Place;
import se.walkercrou.places.exception.GooglePlacesException;

@SuppressWarnings("serial")
@SpringView(name = PlaceSearchPage.NAME)
@MenuCaption("Search place")
@MenuIcon(VaadinIcons.SEARCH)
public class PlaceSearchPage extends CssLayout implements View {

    public static final String NAME = "place-search";

    VaadinMap map;

    PlaceSearchField startPlaceField;
    PlaceSearchField endPlaceField;

    Place startPlace;
    Place endPlace;

    MapsDirections directions;
    Label directionsLabel;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
        map = new VaadinMap();

        Label searchTitle = new Label("Place search");

        startPlaceField = new PlaceSearchField();
        startPlaceField.setPlaceHolder("Search starting place...");
        startPlaceField.setClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    Place result = startPlaceField.searchPlace();
                    if (result != null) {
                        startPlace = result;
                        map.setMarker(startPlace, 1);
                        getDirections();
                    }
                } catch (GooglePlacesException e) {
                    Notification.show("No result found!", Type.WARNING_MESSAGE);
                }
            }
        });

        endPlaceField = new PlaceSearchField();
        endPlaceField.setPlaceHolder("Search ending place...");
        endPlaceField.setClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    Place result = endPlaceField.searchPlace();
                    if (result != null) {
                        endPlace = result;
                        map.setMarker(endPlace, 2);
                        getDirections();
                    }
                } catch (GooglePlacesException e) {
                    Notification.show("No result found!", Type.WARNING_MESSAGE);
                }
            }
        });
        
        HorizontalLayout searchFieldComponents = new HorizontalLayout(startPlaceField, endPlaceField);
        
        VerticalLayout searchField = new VerticalLayout(searchTitle, searchFieldComponents);
        
        directions = new MapsDirections();
        
        Label directionsTitle = new Label("Directions");
        directionsLabel = new Label();
        directionsLabel.setContentMode(ContentMode.PREFORMATTED);
        
        VerticalLayout directionsField = new VerticalLayout(directionsTitle, directionsLabel);
        
        HorizontalLayout menuComponents = new HorizontalLayout(searchField, directionsField);

        VerticalLayout menu = new VerticalLayout(searchField, directionsField);
        menu.setWidth("100%");

        this.addComponents(map, menu);
        this.setSizeUndefined();
        this.setWidth("100%");
    }

    private void getDirections() {
        if (startPlace != null && endPlace != null) {
            DirectionsResult result = directions.calculateDirections(startPlace, endPlace);
            if (result != null) {
                String labelResult = directions.directionsDescription(result);
                /*
                labelResult.replace("\n", "</p><p>");
                labelResult = "<p>" + labelResult + "</p>";
*/
                System.out.println(directionsLabel);
                directionsLabel.setValue(labelResult);
            } else {
                directionsLabel.setValue("No directions found");
            }
        }
    }

}
