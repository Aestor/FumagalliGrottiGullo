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
package com.polimi.fakePTS.tickets;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jaycaves
 */
@Getter
@Setter
public class UrbanTicket extends Ticket {

    private String city;

    public UrbanTicket(int price, TicketType type, int validity, String city) {
        super(price, type, validity);
        this.city = city;
        
    }

  @Override
    public String toString() {
        return "UrbanTicket: "
                + "\n City: "
                + city
                + "\nPrice: "
                + price
                + "\nDay of Purchase: "
                + purchase.toLocalDate().toString()
                + " at "
                + purchase.toLocalTime().toString()
                + "\n Validity: "
                + validity
                + " "
                + lenght; //must be changed in future implementations
    }

}
