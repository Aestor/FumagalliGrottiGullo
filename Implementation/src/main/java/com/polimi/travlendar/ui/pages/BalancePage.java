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
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.travlendar.ui.CheckoutForm;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Page dedicated to user's own balance. Here it is visible the value and it is possible to transfer money.
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = BalancePage.NAME)
@MenuCaption("My Balance")
@MenuIcon(VaadinIcons.CREDIT_CARD)
public class BalancePage extends VerticalLayout implements View {

    public static final String NAME = "Balance";

    
    
    @Autowired
                private CheckoutForm cf;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        //this.addComponent(new BalanceSection());
        
        this.addComponent(cf);

      
        

    }

    private class BalanceSection extends HorizontalLayout{

        public BalanceSection() {
            
            Label title= new Label("MY BALANCE:");
        
        //here balance is queried from db
        }
        
    }
    
}
