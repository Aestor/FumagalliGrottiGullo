/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.frontend.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.vaadin.icons.VaadinIcons;
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
@MenuIcon(VaadinIcons.ABACUS)
public class SettingsPage extends VerticalLayout implements View{
    
    public static final String NAME = "SettingsPage";
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("Settings: " + VaadinSession.getCurrent().getAttribute("user")));
        
    }





}
