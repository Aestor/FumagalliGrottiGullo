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
package com.polimi.travlendar.backend.model.events;

import com.vaadin.ui.Button;
import com.vaadin.ui.Window;

/**
 *This class 
 * @author Aestor
 */
public class OnEventClick extends Window{
    
    public OnEventClick(Meeting meeting) {
        super("On Click Event");
        Button edit = new Button("Edit", e -> {
            close();
        });
        Button delete = new Button("Delete", e -> {
            
        });
        Button close = new Button("Cancel", e ->{
            close();
        });
        
    }
    
    
}
