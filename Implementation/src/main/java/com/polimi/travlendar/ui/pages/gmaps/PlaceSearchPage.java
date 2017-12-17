package com.polimi.travlendar.ui.pages.gmaps;

import java.util.List;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;
import se.walkercrou.places.Prediction;

@SuppressWarnings("serial")
@SpringView(name = PlaceSearchPage.NAME)
@MenuCaption("Search place")
public class PlaceSearchPage extends HorizontalLayout implements View {

	public static final String NAME = "place-search";

	private static final String KEY = "AIzaSyDGsAnfiLGU5WG2Yh7_glDJrRYvDnkGsSg";

	private List<Place> results;
	private List<Prediction> predictions;

	private GoogleMap map;
	private TextField searchTextField;
	private VerticalLayout autoComplete;
	
	private int pred = 0;
	private int sea = 0;

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {

		VerticalLayout side = new VerticalLayout();
		Label title = new Label("Place search");
		searchTextField = new TextField();
		Button submit = new Button(VaadinIcons.SEARCH);
		HorizontalLayout searchField = new HorizontalLayout(searchTextField, submit);
		searchField.setSpacing(false);
		autoComplete = new VerticalLayout();
		autoComplete.setWidth("600px");

		side.addComponents(title, searchField, autoComplete);
		side.setWidth("600px");

		map = new GoogleMap(KEY, null, "english");
		map.setWidth("600px");
		map.setHeight("600px");
		map.setZoom(4);

		this.addComponents(side, map);
		this.setSizeUndefined();

		submit.addClickListener(e -> {
			search(searchTextField.getValue());
		});
		submit.setClickShortcut(KeyCode.ENTER);

		/*
		searchTextField.setValueChangeMode(ValueChangeMode.LAZY);
		searchTextField.addValueChangeListener(e -> {
			predict(searchTextField.getValue());
		});
		*/
	}
	
	private void search(String text) {
		sea++;
		System.out.println("DEBUG::Search n°" + sea);
		new Search(text).start();
	}
	
	private void predict(String text) {
		pred++;
		System.out.println("DEBUG::Prediction n°" + pred);
		new Predict(text).start();
	}
	
	private void setMap(Place place) {
		System.out.println("DEBUG::Setting map...");
		//this.removeComponent(map);
		map.clearMarkers();
		map.addMarker(place.getName(), new LatLon(place.getLatitude(), place.getLongitude()), false, null);
		map.setCenter(new LatLon(place.getLatitude(), place.getLongitude()));
		map.setZoom(16);
		//this.addComponent(map);
	}

	// NETWORK THREADS
	
	private class Search extends Thread {

		private String text;
		
		private GooglePlaces client;

		public Search(String text) {
			this.text = text;
			client = new GooglePlaces(KEY);
		}
		
		@Override
		public void run() {
			if (text == null || text.equals("")) {
				searchTextField.setComponentError(new UserError("This field cannot be empty"));
			} else {
				results = client.getPlacesByQuery(searchTextField.getValue(), 1);
				if (results.size() > 0) {
					setMap(results.get(0));
				} else {
					Notification.show("No result found", Type.ERROR_MESSAGE);
				}
			}
		}
	}

	private class Predict extends Thread {

		private String text;
		
		private GooglePlaces client;

		public Predict(String text) {
			this.text = text;
			client = new GooglePlaces(KEY);
		}

		@Override
		public void run() {
			predictions = client.getPlacePredictions(text);
			autoComplete.removeAllComponents();
			for (Prediction p : predictions) {
				HorizontalLayout row = new HorizontalLayout();
				Label prediction = new Label(p.getDescription());
				Button arrow = new Button(VaadinIcons.ARROW_RIGHT);
				arrow.addClickListener(e -> {
					System.out.println("Prediction clicked!");
					setMap(p.getPlace());
				});
				row.addComponents(arrow, prediction);
				autoComplete.addComponent(row);
			}
		}
	}

}
