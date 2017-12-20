package com.polimi.travlendar.ui.pages.gmaps;


import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.travlendar.gmaps.PlaceSearchField;
import com.polimi.travlendar.gmaps.VaadinMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
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

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Label title = new Label("Place search");

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
                    }
                } catch (GooglePlacesException e) {
                    Notification.show("No result found!", Type.WARNING_MESSAGE);
                }
            }
        });
        
        map = new VaadinMap();

        HorizontalLayout searchField = new HorizontalLayout(startPlaceField, endPlaceField);

        VerticalLayout menu = new VerticalLayout(title, searchField);


        this.addComponents(map, menu);
        this.setSizeFull();
    }

}
