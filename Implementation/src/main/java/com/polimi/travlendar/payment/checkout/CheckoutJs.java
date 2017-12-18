/*
 * Copyright 2017 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.polimi.travlendar.payment.checkout;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * Triggers the checkout_stripe.js script.
 * @author jaycaves
 */
@JavaScript(value = { "vaadin://themes/demo/js/checkout_stripe.js" })
public class CheckoutJs extends AbstractJavaScriptComponent {

    
    private static final long serialVersionUID = -1418946324742025425L;

    public CheckoutJs(String user, String amount) {
        setKey("pk_test_Br0eRZUzudfg2GZQWZVAJxju");
        setAmount(amount);
        setUser(user);
        
    }

    public String getUser(){
        return getState().user;
    }
    
    public void setUser(String user){
        getState().user= user;
    }
    
    public String getAmount() {
        return getState().amount;
    }

    public void setAmount(String amount) {
        getState().amount = amount;
    }

    public String getKey() {
        return getState().key;
    }

    public void setKey(String key) {
        getState().key = key;
    }

    @Override
    protected CheckoutJsLabelState getState() {
        return (CheckoutJsLabelState) super.getState();
    }
}



