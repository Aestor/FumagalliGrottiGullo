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

import com.polimi.fakePTS.RandomTicketId;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Single Public Transportation System's ticket.
 *
 * @author jaycaves
 */
@Getter
@Setter
public class Ticket {

    protected String id;
    protected int price;
    protected TicketType type;
    protected int validity; //depends on ticket type
    protected boolean activated;
    protected ZonedDateTime validationTime;
    protected ZonedDateTime purchase;
    protected String lenght; //used to describe validity time interval

    public Ticket(int price, TicketType type, int validity) {
        id = new RandomTicketId(16).nextString();
        this.price = price;
        this.type = type;
        this.validity = validity;
        this.activated = false;
        purchase = ZonedDateTime.now();
        lenght= setLenght(type);

    }

    /**
     * 
     * @param type
     * @return 
     */
    private String setLenght(TicketType type) {

        switch (type.name) {

            case "single": {
                return "minutes";
            }
            case "weekpass": {
                return "days";
            }
            case "onemonthpass": {
                return "days";
            }
            case "yearpass": {
                return "weeks";
            }
            default: {
                return "error";
            }
        }
    }
    
    public void setLenght(String lenght){
        this.lenght= lenght;
    }

}
