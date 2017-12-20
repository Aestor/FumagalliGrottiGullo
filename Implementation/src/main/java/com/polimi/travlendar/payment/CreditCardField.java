package com.polimi.travlendar.payment;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

@SuppressWarnings("serial")
@JavaScript({"vaadin://themes/demo/js/credit_card_1.1.js", "https://js.stripe.com/v3/"})
@StyleSheet({"vaadin://themes/demo/css/credit_card_1.0.css"})
public class CreditCardField extends AbstractJavaScriptComponent {

	public CreditCardField(String key) {
		callFunction("cardfunction", key);
	}
}
