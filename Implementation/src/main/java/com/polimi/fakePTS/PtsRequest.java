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

import com.polimi.travlendar.user.Ticket;
import java.util.Date;

   /**
 * Here we simulate RPC calls to a PTS API. Since no PTS service in our country grants access to their purchase system, 
 * but we assumed it possible in our RASD and DD, we decided to fake all the calls through this interface. 
 * Its implementation, PtsRequest allows the user to virtually buy and activate tickets. 
 * 
 * @author jaycaves
 */

public class PtsRequest {

    
    public static void activateTicket(Ticket ticket) {
        
       ticket.setActivated(true);
       
    }


    public static Ticket buyTicket(String name, String lastname, Date date, String city, int validity) {
         
        return new Ticket(name, lastname,city, date, validity);
    }
    
 
}
