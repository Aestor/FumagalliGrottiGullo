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
package com.polimi.fakePTS;

import com.polimi.fakePTS.exceptions.InvalidFieldsException;
import com.polimi.fakePTS.exceptions.InvalidTicketException;
import com.polimi.fakePTS.tickets.Ticket;
import com.polimi.fakePTS.tickets.TicketType;
import com.polimi.fakePTS.tickets.TrainTicket;
import com.polimi.fakePTS.tickets.UrbanTicket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

   /**
 * Here we simulate RPC calls to a PTS API. Since no PTS service in our country grants access to their purchase system, 
 * but we assumed it possible in our RASD and DD, we decided to fake all the calls through this interface. 
 * Its implementation, PtsRequest allows the user to virtually buy and activate tickets. 
 * 
 * @author jaycaves
 */

public class PtsRequest {

    
    public static void activateTicket(Ticket ticket) throws InvalidTicketException{
        
      //checks if already validated or expired
       ticket.setActivated(true);
       ticket.setValidationTime(ZonedDateTime.now());
       
    }


    public static UrbanTicket buyUrbanTicket(int price, TicketType type, int validity, String city) throws InvalidFieldsException {
        
         if(price>0){
         UrbanTicket temp = 
         new UrbanTicket(price, type, validity,city);
         return temp;
        }
        else throw new InvalidFieldsException("error");
        
    }
    
    public static TrainTicket buyTrainTicket(int price, String start, String arrival, int validity, TicketType type, LocalDate date) throws InvalidFieldsException {
        
        if(price>0){
         TrainTicket temp = 
         new TrainTicket(start, arrival, price, type, validity);
         temp.setValidationTime(ZonedDateTime.of(date.atTime(LocalTime.MIN), ZoneId.systemDefault()));
         return temp;
        }
        else throw new InvalidFieldsException("error");
    }
    
    /**
     * Returns a list of available Train Stations in tickets' purchases.
     * @return 
     */
    public static List<String> getAvailableTrainStations(){
        List<String> temp = new ArrayList<>();
        temp.add("Milano");
        temp.add("Bergamo");
        temp.add("Genova");
        temp.add("Orio");
        temp.add("Brescia");
        temp.add("Lecco");
        return temp;
    }
    
    public static int getUrbanPrice(TicketType type){
        
        switch (type.name){
            case "single": 
                return 2;
            case "weekpass":
                return 20;
            case "onemonthpass":
                return 35;
            case "yearpass":
                return 250;
            default:
                return 1000000000;
          }
    }
    
    public static int getTrainPrice(String departure, String arrival){
        return ThreadLocalRandom.current().nextInt(0, 100);
    }
}
