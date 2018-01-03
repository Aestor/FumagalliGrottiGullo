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
package com.polimi.travlendar.frontend.ui.forms;

import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.beans.UserService;
import com.polimi.travlendar.payment.checkout.CheckoutJs;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Stripe Checkout form is injected in this view component. User can update his
 * balance here.
 *
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringComponent
@Scope("prototype")
public class CheckoutForm extends VerticalLayout {

    @Autowired
    private UserService service;

    @Autowired
    User user;

    private static final String KEY = "pk_test_Br0eRZUzudfg2GZQWZVAJxju";
    private boolean first;
    private String temp;
    private Component current;

    public CheckoutForm() {

        

        Label title = new Label("UPDATE BALANCE");
        title.setStyleName("mytitle");

        Label rbg = new Label("Choose the money you want to add to your balance");

        RadioButtonGroup<String> single
                = new RadioButtonGroup<>();

        single.setItems("5", "10", "15", "20", "50", "100");

        Button ok = new Button("Boost my balance!");

        addComponents(title, rbg, single, ok);
        setComponentAlignment(title, Alignment.TOP_CENTER);
        setComponentAlignment(rbg, Alignment.TOP_CENTER);
        setComponentAlignment(single, Alignment.TOP_CENTER);
        setComponentAlignment(ok, Alignment.TOP_CENTER);

        first = true;
        temp = "0";

        ok.addClickListener(e -> {

            if ((first) && (single.getValue() != null)) {
                String username = (String) VaadinSession.getCurrent().getAttribute("user");
                CheckoutJs checkout = new CheckoutJs(username, single.getValue() + "00"); //checkout wants amount in cents
                addComponent(checkout);
                setComponentAlignment(checkout, Alignment.TOP_CENTER);
                temp = single.getValue();
                current = checkout;
                first = false;
            }
        });

        ok.addClickListener(e -> {

            if ((!first) && (!temp.equals(single.getValue()))) {

                removeComponent(current);
                String username = (String) VaadinSession.getCurrent().getAttribute("user");
                CheckoutJs checkout = new CheckoutJs(username, single.getValue() + "00"); //checkout wants amount in cents
                addComponent(checkout);
            }

        });

    }

}
