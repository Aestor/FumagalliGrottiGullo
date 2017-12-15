package com.polimi.travlendar.ui.pages;

import org.springframework.context.annotation.Scope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringView
@Scope("prototype")
public class ErrorView extends VerticalLayout implements View {
	
	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		Label label1 = new Label("Undefined error.");
		Label label2 = new Label("(The world will now explode)");
		VerticalLayout errorMessage = new VerticalLayout(label1, label2);
		errorMessage.setWidth("100%");
		addComponents(errorMessage);
		this.setComponentAlignment(errorMessage, Alignment.MIDDLE_CENTER);
		setSizeFull();
	}

}
