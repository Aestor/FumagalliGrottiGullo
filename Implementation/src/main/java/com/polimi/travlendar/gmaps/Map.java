package com.polimi.travlendar.gmaps;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * This component fills itself with a map retrieved with Google Maps Javascript API.
 * @author Emmeggi95
 *
 */
@SuppressWarnings("serial")
@JavaScript({"showMap_1.1.js", "https://maps.googleapis.com/maps/api/js?key=AIzaSyDGsAnfiLGU5WG2Yh7_glDJrRYvDnkGsSg&v=3.exp"})
@StyleSheet({"mapStyle_1.1.css"})
public class Map extends AbstractJavaScriptComponent {

    public Map(Float lat, Float lon) {
       callFunction("myfunction", lat, lon); //Pass parameters to your function
    }
}
