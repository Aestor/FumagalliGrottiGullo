package com.polimi.travlendar.frontend.ui;

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
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.beans.UserService;
import com.polimi.travlendar.frontend.ui.pages.AuthenticationPage;
import com.polimi.travlendar.frontend.ui.pages.BalancePage;
import com.polimi.travlendar.frontend.ui.pages.CreateEventPage;
import com.polimi.travlendar.frontend.ui.pages.ErrorView;
import com.polimi.travlendar.frontend.ui.pages.SchedulePage;
import com.polimi.travlendar.frontend.ui.pages.SettingsPage;
import com.polimi.travlendar.frontend.ui.pages.SharingServicesPage;
import com.polimi.travlendar.frontend.ui.pages.TestingPage;
import com.polimi.travlendar.frontend.ui.pages.TicketsPage;
import com.polimi.travlendar.frontend.ui.pages.gmaps.MapsAddOnPage;
import com.polimi.travlendar.frontend.ui.pages.gmaps.PlaceSearchPage;
import com.polimi.travlendar.frontend.ui.pages.WelcomePage;
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

/**
 * Spring Vaadin UI. Where all pages are built on. Here it is possible to configure the web servlets. Contains also the methods to create the Menu bar.
 */
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
     * Creates dynamic menu. Not instantiated until user has logged in.
     */
    public void setMenuBar() {
    	setContent(AppLayoutBuilder.get(Behaviour.LEFT_RESPONSIVE)
                .withTitle("Travlendar+")
                .withDesign(AppBarDesign.MATERIAL)
                .withCDI(true)
                .withNavigationElementInfoProvider(new DefaultSpringNavigationElementInfoProvider())
                .add(new MenuHeader( VaadinSession.getCurrent().getAttribute("user").toString(), new ThemeResource("images/google_travel_logo.png")), Position.HEADER)
                //.add(TestingPage.class)
                //.add(MapsAddOnPage.class)
                //.add(PlaceSearchPage.class)
                .add(SchedulePage.class)
                .add(CreateEventPage.class)
                .add(SettingsPage.class)
                .add(BalancePage.class)
                .add(TicketsPage.class)
                .add(SharingServicesPage.class)
                .add(AuthenticationPage.class, Position.FOOTER)
                .withNavigatorProducer(components -> {
                    navigator.init(this, components);
                    navigator.setErrorView(ErrorView.class);
                    return navigator;
                })
                .build()
                
        );
        getNavigator().navigateTo(WelcomePage.NAME);
         
    }
    
    public void setUnloggedMenuBar() {
    	setContent(AppLayoutBuilder.get(Behaviour.TOP)
                .withTitle("Travlendar+")
                .withDesign(AppBarDesign.MATERIAL)
                .withCDI(true)
                .withNavigationElementInfoProvider(new DefaultSpringNavigationElementInfoProvider())
                .add(new MenuHeader("Unlogged user", new ThemeResource("images/google_travel_logo.png")), Position.HEADER)
                .withNavigatorProducer(components -> {
                    navigator.init(this, components);
                    navigator.setErrorView(ErrorView.class);
                    return navigator;
                })
                .build()
        );
    	navigator.navigateTo(AuthenticationPage.NAME);
    }

}
