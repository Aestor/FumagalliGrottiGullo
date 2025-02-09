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
package com.polimi.travlendar.frontend.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.travlendar.backend.beans.StripeService;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.frontend.ui.forms.CheckoutForm;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Page dedicated to user's own balance. Here it is visible the value and it is
 * possible to transfer money.
 *
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = BalancePage.NAME)
@MenuCaption("My Balance")
@MenuIcon(VaadinIcons.CREDIT_CARD)
public class BalancePage extends VerticalLayout implements View {

    public static final String NAME = "Balance";
    private Long current_balance;

    @Autowired
    private StripeService service;

    @Autowired
    private CheckoutForm cf;

    @Autowired
    User user;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Balance balance = new Balance();
        this.addComponent(balance);
        this.setComponentAlignment(balance, Alignment.MIDDLE_CENTER);

        this.addComponent(cf);
        this.setComponentAlignment(cf, Alignment.TOP_CENTER);

    }

    /**
     * Panel to show user's balance.
     *
     * @author jaycaves
     */
    private class Balance extends VerticalLayout{

        public Balance() {

            
            Label title = new Label("YOUR BALANCE: \n");
            title.setStyleName("mytitle");

            current_balance = service.getBalance();
            Component b = new Panel(current_balance.toString() + " $$");
            b.setSizeUndefined();
            b.setStyleName("balance");
            

            addComponents(title, b);
            setComponentAlignment(b, Alignment.MIDDLE_CENTER);
            setComponentAlignment(title, Alignment.TOP_CENTER);

        }

    }

}
