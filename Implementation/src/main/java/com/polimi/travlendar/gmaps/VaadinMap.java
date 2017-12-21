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

import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.VerticalLayout;
import se.walkercrou.places.Place;

/**
 *
 * @author Marco
 */
public class VaadinMap extends VerticalLayout {

    private static final String KEY = "AIzaSyDGsAnfiLGU5WG2Yh7_glDJrRYvDnkGsSg";

    private GoogleMap map;

    private Place[] places;

    public VaadinMap() {
        map = new GoogleMap(KEY, null, null);
        map.setSizeFull();
        map.setZoom(4);
        map.setMinZoom(4);
        map.setMaxZoom(20);

        this.addComponent(map);
        this.setExpandRatio(map, 1.0f);
        this.setHeight("500px");

        places = new Place[2];
    }

    public void setMarker(Place place, int i) {
        if (places.length >= i) {
            places[i - 1] = place;
            map.clearMarkers();
            Double lat = new Double(0);
            Double lon = new Double(0);
            int nullCounter = 0;
            LatLon ne = new LatLon(new Double(0), new Double(0));
            LatLon sw = new LatLon(new Double(0), new Double(0));
            for (Place p : places) {
                if (p!=null) {
                    map.addMarker(p.getName(), new LatLon(p.getLatitude(), p.getLongitude()), false, null);
                    lat += p.getLatitude();
                    lon += p.getLongitude();
                    if(ne==null && sw==null){
                        ne = new LatLon(p.getLatitude(), p.getLongitude());
                    } else {
                        if(p.getLatitude()>ne.getLat())
                            ne.setLat(p.getLatitude());
                        if(p.getLatitude()<sw.getLat())
                            sw.setLat(p.getLatitude());
                        if(p.getLongitude()>ne.getLon())
                            ne.setLon(p.getLongitude());
                        if(p.getLongitude()<sw.getLon())
                            ne.setLon(p.getLongitude());
                    }
                } else
                    nullCounter++;
            }
            lat = lat / (places.length - nullCounter);
            lon = lon / (places.length - nullCounter);
            map.setCenter(new LatLon(lat, lon));
            map.setZoom(4); // Provvisorio
            map.setCenterBoundLimits(ne, sw);
            map.setCenterBoundLimitsEnabled(true);
        } else {
            System.err.println("Exceded places[] array in VaadinMap object.");
        }
    }
}
