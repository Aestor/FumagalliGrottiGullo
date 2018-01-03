/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.frontend.ui.pages;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = WelcomePage.NAME)
public class WelcomePage extends VerticalLayout implements View{

     public static final String NAME = "Welcome";
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        
        Image img = new Image("", new ThemeResource("images/travel2.jpeg"));
        img.setWidth(1000, Unit.PIXELS);
        addComponent(img);
        setComponentAlignment(img, Alignment.TOP_CENTER);
        Label intro= new Label("WELCOME "+ VaadinSession.getCurrent().getAttribute("user")+ " ! \n\n ");
        intro.setStyleName("originalcaption");
        addComponent(intro);
        setComponentAlignment(intro, Alignment.TOP_CENTER);

    }
     
     
}
