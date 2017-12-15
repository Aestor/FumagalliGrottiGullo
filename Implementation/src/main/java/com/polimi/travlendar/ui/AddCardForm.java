package com.polimi.travlendar.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.polimi.travlendar.payment.CreditCardField;
import com.polimi.travlendar.payment.PaymentServiceImpl;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
@SpringComponent
@Scope("prototype")
public class AddCardForm extends FormLayout {
    
    @Autowired
   private  PaymentServiceImpl paymentHandler;
    
    private static final String KEY = "pk_test_Br0eRZUzudfg2GZQWZVAJxju";
    
    private TextField name = new TextField();
    private TextField lastname= new TextField();
    
    public AddCardForm() {
    	CreditCardField field = new CreditCardField(KEY);
    	field.setId("cardform");
    	this.addComponent(field);
    	field.setWidth("300px");
    }
    
	
	

	
}
