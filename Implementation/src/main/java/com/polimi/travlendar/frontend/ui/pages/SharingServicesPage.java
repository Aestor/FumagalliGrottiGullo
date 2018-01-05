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
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Here user can access some sponsored car and bike sharing services.
 *
 * @author jaycaves
 */
@SuppressWarnings("serial")
@SpringView(name = SharingServicesPage.NAME)
@MenuCaption("Sharing Services")
@MenuIcon(VaadinIcons.SHARE)
public class SharingServicesPage extends VerticalLayout implements View {

    public static final String NAME = "SharingServicesPage";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Label cars = new Label("CAR SHARING:");
        cars.setStyleName("mytitle");
        Button enjoy = new Button("Enjoy");
        enjoy.addClickListener(e -> {
            getUI().getPage().open("https://enjoy.eni.com/it/milano/home", "_blank");
        });
        //ThemeResource image = new ThemeResource("images/enjoy.jpg");
        //enjoy.setIcon(image);
        Button car2go = new Button("Car2Go");
        car2go.addClickListener(e -> {
            getUI().getPage().open("https://www.car2go.com/IT/it/milano/", "_blank");
        });
        Button shareNgo = new Button("ShareNGo");
        shareNgo.addClickListener(e -> {
            getUI().getPage().open("http://site.sharengo.it/", "_blank");
        });
        addComponents(cars, enjoy, car2go, shareNgo);
        setComponentAlignment(cars, Alignment.MIDDLE_CENTER);
        setComponentAlignment(enjoy, Alignment.MIDDLE_CENTER);
        setComponentAlignment(car2go, Alignment.MIDDLE_CENTER);
        setComponentAlignment(shareNgo, Alignment.MIDDLE_CENTER);
        
        Label bikes = new Label("BIKE SHARING:");
        bikes.setStyleName("mytitle");
        Button bikeMi = new Button("BikeMi");
        bikeMi.addClickListener(e -> {
            getUI().getPage().open("https://www.bikemi.com/", "_blank");
        });
        Button ofo = new Button("Ofo");
        ofo.addClickListener(e -> {
            getUI().getPage().open("https://www.ofo.com/it/it", "_blank");
        });
        Button mobike = new Button("Mobike");
        mobike.addClickListener(e -> {
            getUI().getPage().open("https://mobike.com/it/", "_blank");
        });
        addComponents(bikes, bikeMi,ofo, mobike);
        setComponentAlignment(bikes, Alignment.MIDDLE_CENTER);
        setComponentAlignment(bikeMi, Alignment.MIDDLE_CENTER);
        setComponentAlignment(ofo, Alignment.MIDDLE_CENTER);
        setComponentAlignment(mobike, Alignment.MIDDLE_CENTER);
        
        Image image = new Image ("", new ThemeResource("images/share.jpg"));
        image.setHeight("500px");
        addComponent(image);
        setComponentAlignment(image, Alignment.MIDDLE_CENTER);

    }

}
