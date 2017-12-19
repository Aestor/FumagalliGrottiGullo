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
import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.vaadin.tapio.googlemaps.client.LatLon;

/**
 *
 * @author Marco
 */
public class MapsDirections {
    
    private static final String KEY = "AIzaSyD6IaaO4KPZcEWmYzKRS9wtCvYnt2WyfrA";
    
    private GeoApiContext context;
    
    public MapsDirections(){
        context = new GeoApiContext.Builder(new GaeRequestHandler.Builder()).apiKey(KEY).build();
    }
    
    public DirectionsResult calculateDirections(LatLon start, LatLon end){
        DirectionsApiRequest request = DirectionsApi.newRequest(context);
        // set start and end...
        DirectionsResult result;
        try{
            result = request.await();
            return result;
        } catch (Exception e){
            // Do something...
        }
        return null;
    }
    
}
