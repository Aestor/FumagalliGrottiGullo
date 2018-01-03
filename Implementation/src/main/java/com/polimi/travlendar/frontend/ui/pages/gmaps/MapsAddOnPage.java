package com.polimi.travlendar.frontend.ui.pages.gmaps;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Page showing a map with Google Maps Vaadin add-on by Team Parttio
 * @author Emmeggi95
 *
 */
@SuppressWarnings("serial")
@SpringView(name = MapsAddOnPage.NAME)
@MenuCaption("Map")
@MenuIcon(VaadinIcons.MAP_MARKER)
public class MapsAddOnPage extends VerticalLayout implements View {
	
	public static final String NAME = "maps-addon";
	
	private static final String KEY = "AIzaSyDGsAnfiLGU5WG2Yh7_glDJrRYvDnkGsSg";
	
	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		GoogleMap googleMap = new GoogleMap(KEY, null, "english");
		googleMap.setWidth("600px");
		googleMap.setHeight("600px");
		googleMap.setCenter(new LatLon(45.4782167, 9.2250863));
		googleMap.addMarker("Politecnico di Milano", new LatLon(45.4782167, 9.2250863), false, null);
		googleMap.setMinZoom(4);
		googleMap.setMaxZoom(20);
		googleMap.setZoom(16);
		this.addComponents(new Label("Google Maps with Vaadin Addon"), googleMap);
	}

}
