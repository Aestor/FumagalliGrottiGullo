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
package com.polimi.travlendar.user;

import com.polimi.fakePTS.RandomTicketId;
import java.time.Instant;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Single Public Transportation System's ticket.
 * @author jaycaves
 */
@Getter
@Setter
public class Ticket {
    
    private String id;
    private String name;
    private String lastname;
    private String city;
    private Date date;
    private int validity; //minutes
    private boolean activated;

    public Ticket(String name, String lastname, String city, Date date, int validity) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.date = date;
        id = new RandomTicketId(16).nextString();
        this.activated=false;
        this.validity=validity;
        
    }

    public Ticket() {
        this.id = "";
        this.city= "";
        this.name="";
        this.lastname="";
        this.date= Date.from(Instant.now());
        this.activated=false;
        this.validity= 0;
    }

    @Override
    public String toString() {
        return "Ticket: \n" + "id=" 
                + id 
                +"\nvalidity="
                + validity
                + "\nname="
                + name 
                + "\nlastname=" 
                + lastname 
                + "\ncity=" 
                + city 
                + "\ndate=" 
                + date 
                + "\nactivated=" 
                + activated 
                + "\n";
    }
    
    
}
