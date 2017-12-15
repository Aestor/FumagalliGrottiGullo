package com.polimi.travlendar.ui.pages.gmaps;

import com.polimi.travlendar.gmaps.Map;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Page showing a map with Javascript.
 * @author Emmeggi95
 *
 */
@SuppressWarnings("serial")
@SpringView(name = MapsPage.NAME)
@Theme("map")
public class MapsPage extends VerticalLayout implements View {

	public static final String NAME = "maps";

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		Map mapobject = new Map(new Float(45.4782167), new Float(9.2250863));
        mapobject.setId("mapob");
        this.addComponents(new Label("Google Maps with Javascript"), mapobject);
	}
}
