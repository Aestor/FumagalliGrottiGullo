package com.polimi.travlendar.ui;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder.Position;
import com.github.appreciated.app.layout.builder.design.AppBarDesign;
import com.github.appreciated.app.layout.builder.entities.DefaultBadgeHolder;
import com.github.appreciated.app.layout.builder.entities.DefaultNotificationHolder;
import com.github.appreciated.app.layout.builder.providers.DefaultSpringNavigationElementInfoProvider;
import com.github.appreciated.app.layout.component.MenuHeader;
import com.polimi.travlendar.User;
import com.polimi.travlendar.UserService;
import com.polimi.travlendar.ui.pages.AuthenticationPage;
import com.polimi.travlendar.ui.pages.ErrorView;
import com.polimi.travlendar.ui.pages.SchedulePage;
import com.polimi.travlendar.ui.pages.SettingsPage;
import com.polimi.travlendar.ui.pages.TestingPage;
import com.polimi.travlendar.ui.pages.gmaps.MapsAddOnPage;
import com.polimi.travlendar.ui.pages.gmaps.PlaceSearchPage;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.EnableVaadinNavigation;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Viewport("initial-scale=1, maximum-scale=1")
@Theme("demo")
@SpringUI
@SpringViewDisplay
@SuppressWarnings("serial")

public class TravlendarUI extends UI {

    @Autowired
    private UserService service;
    
    @Autowired
    SpringNavigator navigator;
    
    private User currentUser;

    public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	@Override
    protected void init(VaadinRequest request) {
        holder = new VerticalLayout();
        holder.setSizeUndefined();
        getPage().setTitle("TravlendarPlus");
        if(VaadinSession.getCurrent().getAttribute("user")!=null)
        	setMenuBar();
        else
        	setUnloggedMenuBar();
    }

    DefaultNotificationHolder notifications = new DefaultNotificationHolder();
    DefaultBadgeHolder badge = new DefaultBadgeHolder();
    private VerticalLayout holder;

    public UserService getService() {
        return service;
    }

    @Configuration
    @EnableVaadin
    @EnableVaadinNavigation
    public static class SpringConfiguration {
    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = TravlendarUI.class)
    public static class Servlet extends VaadinServlet {
    }

    /**
     * Creates dynamic menu. Must not be done before user has logged in.
     */
    protected void setMenuBar() {
    	setContent(AppLayoutBuilder.get(Behaviour.LEFT_RESPONSIVE)
                .withTitle("Appbar Demo")
                .withDesign(AppBarDesign.MATERIAL)
                .withCDI(true)
                .withNavigationElementInfoProvider(new DefaultSpringNavigationElementInfoProvider())
                .add(new MenuHeader("Current user", VaadinSession.getCurrent().getAttribute("user").toString(), new ThemeResource("logo.png")), Position.HEADER)
                .add(TestingPage.class)
                .add(MapsAddOnPage.class)
                .add(PlaceSearchPage.class)
                .add(SchedulePage.class)
                .add(SettingsPage.class)
                .add(AuthenticationPage.class, Position.FOOTER)
                .withNavigatorProducer(components -> {
                    navigator.init(this, components);
                    navigator.setErrorView(ErrorView.class);
                    return navigator;
                })
                .build()
        );
    }
    
    public void setUnloggedMenuBar() {
    	setContent(AppLayoutBuilder.get(Behaviour.TOP)
                .withTitle("Login | Register")
                .withDesign(AppBarDesign.MATERIAL)
                .withCDI(true)
                .withNavigationElementInfoProvider(new DefaultSpringNavigationElementInfoProvider())
                .add(new MenuHeader("Unlogged user", new ThemeResource("logo.png")), Position.HEADER)
                .withNavigatorProducer(components -> {
                    navigator.init(this, components);
                    navigator.setErrorView(ErrorView.class);
                    return navigator;
                })
                .build()
        );
    	navigator.navigateTo(TestingPage.NAME);
    }

}
