package com.polimi.travlendar.ui.pages.gmaps;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.PlacesSearchResult;
import com.polimi.travlendar.gmaps.GoogleMapsService;
import com.polimi.travlendar.gmaps.PlaceSearchField;
import com.polimi.travlendar.gmaps.ResultNotFoundException;
import com.polimi.travlendar.gmaps.VaadinMap;
import com.vaadin.data.HasValue;
import com.vaadin.data.HasValue.ValueChangeListener;
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
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
@SpringView(name = PlaceSearchPage.NAME)
@MenuCaption("Search place")
@MenuIcon(VaadinIcons.SEARCH)
public class PlaceSearchPage extends CssLayout implements View {

    public static final String NAME = "place-search";

    VaadinMap map;

    @Autowired
    PlaceSearchField startPlaceField;
    @Autowired
    PlaceSearchField endPlaceField;

    PlacesSearchResult startPlace;
    PlacesSearchResult endPlace;

    @Autowired
    GoogleMapsService service;
    Label directionsLabel;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        map = new VaadinMap();

        Label searchTitle = new Label("Place search");

        startPlaceField.setPlaceHolder("Search starting place...");
        startPlaceField.setClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    PlacesSearchResult result = startPlaceField.searchPlace();
                    if (result != null) {
                        startPlace = result;
                        map.setMarker(startPlace, 1);
                        getDirections();
                    }
                } catch (ResultNotFoundException e) {
                    Notification.show(e.placesMessage, Type.WARNING_MESSAGE);
                }
            }
        });

        endPlaceField.setPlaceHolder("Search ending place...");
        endPlaceField.setClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    PlacesSearchResult result = endPlaceField.searchPlace();
                    if (result != null) {
                        endPlace = result;
                        map.setMarker(endPlace, 2);
                        getDirections();
                    }
                } catch (ResultNotFoundException e) {
                    Notification.show(e.placesMessage, Type.WARNING_MESSAGE);
                }
            }
        });

        HorizontalLayout searchFieldComponents = new HorizontalLayout(startPlaceField, endPlaceField);

        VerticalLayout searchField = new VerticalLayout(searchTitle, searchFieldComponents);

        service = new GoogleMapsService();

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
