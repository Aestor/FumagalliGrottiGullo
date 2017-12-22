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
import com.google.maps.PendingResult;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.TextSearchRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.vaadin.spring.annotation.SpringComponent;
import java.io.IOException;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Marco
 */
@SpringComponent
@Scope("prototype")
public class GoogleMapsService {

    private static final String KEY = "AIzaSyD6IaaO4KPZcEWmYzKRS9wtCvYnt2WyfrA";

    private static GeoApiContext context;

    public GoogleMapsService() {
        if (context == null) {
            context = new GeoApiContext.Builder().apiKey(KEY).build();
        }
    }

    public DirectionsResult calculateDirections(PlacesSearchResult start, PlacesSearchResult end) throws Exception {
        DirectionsApiRequest request = DirectionsApi.newRequest(context);
        request.origin(start.geometry.location);
        request.destination(end.geometry.location);
        //System.out.println("Searching directions\nfrom: " + start.geometry.location.toString() + "\nto:   " + start.geometry.location.toString());
        DirectionsResult result;
        try {
            result = request.await();
            if(result.routes.length == 0){
                throw new ResultNotFoundException();
            }
            return result;
        } catch (ApiException | IOException | InterruptedException e) {
            e.printStackTrace();
            throw e;
        }

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

    public PlacesSearchResult searchPlace(String query) throws Exception {
        TextSearchRequest request = new TextSearchRequest(context);
        request.query(query);
        PlacesSearchResponse response = null;
        try {
            response = request.await();
        } catch (ApiException | IOException | InterruptedException e) {
            throw e;
        }
        PlacesSearchResult[] results = response.results;
        if (results.length > 0) {
            return results[0];
        } else {
            throw new ResultNotFoundException();
        }
    }
    
    public void predict(AutocompleteClient client, String text){
        System.out.println("Service: predicting...");
        PlaceAutocompleteRequest request = PlacesApi.placeAutocomplete(context, text);
        request.setCallback(new PendingResult.Callback<AutocompletePrediction[]>() {
            @Override
            public void onResult(AutocompletePrediction[] t) {
                client.deliverPredictions(t);
            }

            @Override
            public void onFailure(Throwable thrwbl) {
                client.predictionError();
            }
            
        });
    }

}
