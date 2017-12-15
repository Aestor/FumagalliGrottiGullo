package com.polimi.travlendar.ui;

import com.polimi.travlendar.payment.PaymentServiceImpl;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@SpringComponent
@Scope("prototype")
public class AddCardForm extends FormLayout {
    
    @Autowired
   private  PaymentServiceImpl paymentHandler;
    
    private TextField name = new TextField();
    private TextField lastname= new TextField();
    
	
	

	
}
