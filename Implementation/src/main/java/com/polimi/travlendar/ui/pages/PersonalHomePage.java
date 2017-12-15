/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.ui.pages;

import com.polimi.travlendar.ui.pages.gmaps.PlaceSearchPage;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * HomePage of the web App.
 *
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = PersonalHomePage.NAME)
public class PersonalHomePage extends VerticalLayout implements View {

    public static final String NAME = "YourPersonalPage";
    CssLayout body;

    public PersonalHomePage() {
        
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("Personal Home Page: " + VaadinSession.getCurrent().getAttribute("user")));
        Button navigate = new Button("Map");
        navigate.addClickListener(e -> getUI().getNavigator().navigateTo(PlaceSearchPage.NAME));
        addComponent(navigate);
    }

   

}
