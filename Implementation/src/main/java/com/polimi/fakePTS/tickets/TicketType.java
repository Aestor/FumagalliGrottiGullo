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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Different types of Ticket.
 * @author jaycaves
 */
public enum TicketType {

    SINGLE("single"), WEEKPASS("weekpass"), ONEMONTHPASS("onemonthpass"), YEARPASS("yearpass");

    public final String name;
    private static final List<String> VALUES;

     static {
        VALUES = new ArrayList<>();
        for (TicketType someEnum : TicketType.values()) {
            VALUES.add(someEnum.name);
        }
    }
    
    private TicketType(String name) {
        this.name = name;
    }

    public static List<String> getValues() {
        return Collections.unmodifiableList(VALUES);
    }
    
    @Override
    public String toString() {
        return name;
    }

}
