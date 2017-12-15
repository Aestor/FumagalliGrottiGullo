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
package com.polimi.travlendar.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.polimi.travlendar.User;
import com.polimi.travlendar.ui.AddCardForm;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView( name= CardsPage.NAME)
@MenuCaption("My Cards")
public class CardsPage extends VerticalLayout implements View{
    
    public static final String NAME = "My Cards";
    
    @Autowired
    AddCardForm adder;
    
    @Autowired
    User user;
    
     @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //request all cards known
        //show all cards
        fetchCards();
        Button addCard = new Button("Add Card");
        
        
        
    }
    
    private void fetchCards(){
        
        
    }
}
