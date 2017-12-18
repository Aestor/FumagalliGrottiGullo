package com.polimi.travlendar.ui.pages.gmaps;

import java.util.List;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;
import se.walkercrou.places.Prediction;
import se.walkercrou.places.exception.GooglePlacesException;

@SuppressWarnings("serial")
@SpringView(name = PlaceSearchPage.NAME)
@MenuCaption("Search place")
@MenuIcon(VaadinIcons.SEARCH)
public class PlaceSearchPage extends CssLayout implements View {

	public static final String NAME = "place-search";

	private static final String KEY = "AIzaSyDGsAnfiLGU5WG2Yh7_glDJrRYvDnkGsSg";

	private List<Place> results;
	private List<Prediction> predictions;

	private GoogleMap map;
	private TextField searchTextField;

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {

		
		Label title = new Label("Place search");
		searchTextField = new TextField();
                
		Button searchButton = new Button(VaadinIcons.SEARCH);
                searchButton.setClickShortcut(KeyCode.ENTER);
		searchButton.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						String text = searchTextField.getValue();
						if (text == null || text.equals("")) {
							//System.out.println("DEBUG::ERROR: text field empty");
							searchTextField.setComponentError(new UserError("This field cannot be empty"));
						} else {
							boolean success = false;
							try {
                                                                GooglePlaces client = new GooglePlaces(KEY);
								results = client.getPlacesByQuery(text, GooglePlaces.MAXIMUM_RESULTS);
								success = true;
							} catch (GooglePlacesException e) {
								//System.out.println("DEBUG::No result found");
								Notification.show("No result found!", Type.WARNING_MESSAGE);
							}
							if (success) {
								//System.out.println("DEBUG::Results found!");
								setMap(results.get(0));
							}
						}
					}
				});
                
		searchTextField.addFocusListener(e -> {
			searchTextField.setComponentError(null);
		});
                
		HorizontalLayout searchBar = new HorizontalLayout(searchTextField, searchButton);
		searchBar.setSpacing(false);
                
                VerticalLayout searchField = new VerticalLayout();
		searchField.addComponents(title, searchBar);
		
		VerticalLayout mapContainer = new VerticalLayout();

		map = new GoogleMap(KEY, null, null);
		map.setSizeFull();
		map.setZoom(4);
		map.setMinZoom(4);
		map.setMaxZoom(18);
		
		mapContainer.addComponent(map);
		mapContainer.setExpandRatio(map, 1.0f);
                mapContainer.setHeight("500px");
		
		this.addComponents(mapContainer, searchField);		
		this.setSizeFull();
	}
	
	private void setMap(Place place) {
		//System.out.println("DEBUG::Setting map...\nPlace: " + place.getName() + "\nLat: " + place.getLatitude() + "\nLon: " + place.getLongitude());
		map.clearMarkers();
		map.setCenter(new LatLon(place.getLatitude(), place.getLongitude()));
		map.addMarker(place.getName(), new LatLon(place.getLatitude(), place.getLongitude()), false, null);
		map.setZoom(16);
	}
}
