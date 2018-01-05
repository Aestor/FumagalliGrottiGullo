/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.frontend.ui.pages;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.frontend.ui.forms.UpdateAccountForm;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Here user can see and customize his account data and preferences.
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = SettingsPage.NAME)
@MenuCaption("Settings")
@MenuIcon(VaadinIcons.ABACUS)
public class SettingsPage extends VerticalLayout implements View{
    
    public static final String NAME = "SettingsPage";
    
    @Autowired
    UpdateAccountForm form;
    
    @Autowired
    User user;
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
        
        addComponent(form);
        setComponentAlignment(form, Alignment.MIDDLE_LEFT);
        form.init();
        
    }





}
