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

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.LatLng;
import se.walkercrou.places.Place;

/**
 *
 * @author Marco
 */
public class MapsDirections {

    private static final String KEY = "AIzaSyD6IaaO4KPZcEWmYzKRS9wtCvYnt2WyfrA";

    private GeoApiContext context;

    public MapsDirections() {
        context = new GeoApiContext.Builder().apiKey(KEY).build();
    }

    public DirectionsResult calculateDirections(Place start, Place end) {
        DirectionsApiRequest request = DirectionsApi.newRequest(context);
        request.origin(new LatLng(start.getLatitude(), start.getLongitude()));
        request.destination(new LatLng(end.getLatitude(), end.getLongitude()));
        DirectionsResult result;
        try {
            result = request.await();
            return result;
        } catch (Exception e) {
            // Do something...
        }
        return null;
    }

    public String directionsDescription(DirectionsResult dir) {
        String result = "Routes:\n\n";
        int i = 1;
        for (DirectionsRoute r : dir.routes) {
            result += "Route " + i + ".\n";
            result += "Summary: " + r.summary + "\n";
            int j = 1;
            String space = "    ";
            for (DirectionsLeg l : r.legs) {
                result += space + "Leg " + j + ":\n";
                result += space + "Start address: " + l.startAddress + ".\n";
                result += space + "End address: " + l.endAddress + ".\n";
                result += space + "Distance: " + l.distance.humanReadable + ".\n";
                result += space + "Duration: " + l.duration.humanReadable + ".\n";
            }
        }
        return result;
    }

}
