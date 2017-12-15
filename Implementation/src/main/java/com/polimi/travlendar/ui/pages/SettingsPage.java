/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Here user can see and customize his account data
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = SettingsPage.NAME)
@MenuCaption("Settings")
public class SettingsPage extends VerticalLayout implements View{
    
    public static final String NAME = "SettingsPage";
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("Settings: " + VaadinSession.getCurrent().getAttribute("user")));
        
    }





}
