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

import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResult;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapPolyline;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class VaadinMap extends VerticalLayout {

    private static final String KEY = "AIzaSyDGsAnfiLGU5WG2Yh7_glDJrRYvDnkGsSg";
    private int MAX_ZOOM = 20;
    private int MIN_ZOOM = 0;
    private int DEFAULT_ZOOM = 16;
    private Integer HEIGHT = 500;
    
    private GoogleMap map;

    private PlacesSearchResult[] places;

    private GoogleMapPolyline[] polylines;

    public VaadinMap() {
        map = new GoogleMap(KEY, null, null);
        map.setSizeFull();
        map.setZoom(4);
        map.setMinZoom(MIN_ZOOM);
        map.setMaxZoom(MAX_ZOOM);

        this.addComponent(map);
        this.setSizeFull();
        this.setHeight(HEIGHT.toString() + "px");

        places = new PlacesSearchResult[2];
        polylines = new GoogleMapPolyline[1];
    }

    public VaadinMap(int placesNumber) {
        this();
        places = new PlacesSearchResult[placesNumber];
    }
    
    public VaadinMap(int placesNumber, int polylinesNumber){
        this(placesNumber);
        polylines = new GoogleMapPolyline[polylinesNumber];
    }

    public void setMarker(PlacesSearchResult place, int i) {
        if (places.length >= i) {
            places[i - 1] = place;
            map.clearMarkers();
            int nullCounter = 0;
            LatLon center = new LatLon(new Double(0), new Double(0));
            Double minLat=null, maxLat=null, minLon=null, maxLon=null;
            for (PlacesSearchResult p : places) {
                if (p == null) {
                    nullCounter++;
                } else {
                    Double latitude = p.geometry.location.lat;
                    Double longitude = p.geometry.location.lng;
                    map.addMarker(p.name, convert(p.geometry.location), false, null);
                    center.setLat(center.getLat() + latitude);
                    center.setLon(center.getLon() + longitude);
                    if(minLat == null){
                        minLat = latitude;
                        maxLat = latitude;
                        minLon = longitude;
                        maxLon = longitude;
                    } else {
                        if(latitude < minLat){
                            minLat = latitude;
                        }
                        if(latitude > maxLat){
                            maxLat = latitude;
                        }
                        if(longitude < minLon){
                            minLon = longitude;
                        }
                        if(longitude > maxLon){
                            maxLon = longitude;
                        }
                    }
                }
            }
            
            center.setLat(center.getLat() / (places.length - nullCounter));
            center.setLon(center.getLon() / (places.length - nullCounter));
            map.setCenter(center);
            
            Double distance = Double.max(maxLat-minLat, maxLon-minLon);
            int zoomLevel = DEFAULT_ZOOM;
            while(Math.pow(new Double(2), new Double(zoomLevel))*distance > HEIGHT*0.8){
                zoomLevel--;
            }
            map.setZoom(zoomLevel);
        } else {
            System.err.println("Error in VaadinMap.setMarker request: integer exceedes places[] array length.");
        }
    }

    private LatLon convert(LatLng source) {
        return new LatLon(source.lat, source.lng);
    }

    private List<LatLon> convert(List<LatLng> source) {
        List<LatLon> result = new ArrayList<LatLon>();
        for (LatLng s : source) {
            result.add(new LatLon(s.lat, s.lng));
        }
        return result;
    }

    public void addPolyline(DirectionsResult directions, int i) {
        if (polylines[i-1] != null) {
            map.removePolyline(polylines[i-1]);
        }
        polylines[i-1] = new GoogleMapPolyline(convert(directions.routes[0].overviewPolyline.decodePath()));
        map.addPolyline(polylines[i-1]);
    }
    
    public void addPolyline(DirectionsResult directions) {
        addPolyline(directions, 1);
    }
}
