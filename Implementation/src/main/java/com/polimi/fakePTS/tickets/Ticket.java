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

    public Ticket(int price, TicketType type) {
        id = new RandomTicketId(16).nextString();
        this.price = price;
        this.type = type;
        this.activated = false;
        purchase = ZonedDateTime.now();
        setLenghtAndValidity(type);

    }

    /**
     * 
     * @param type
     * @return 
     */
    private void setLenghtAndValidity(TicketType type) {

        switch (type.name) {

            case "single": {
                setLenght( "minutes");
                setValidity(300);
                break;
            }
            case "weekpass": {
                setLenght("days");
                setValidity(7);
                break;
            }
            case "onemonthpass": {
                setLenght("days");
                setValidity(30);
                break;
            }
            case "yearpass": {
                setLenght("months");
                setValidity(12);
                break;
            }
            default: {
                setLenght("error");
                setValidity(0);
            }
        }
    }
    
    public void setLenght(String lenght){
        this.lenght= lenght;
    }

}
