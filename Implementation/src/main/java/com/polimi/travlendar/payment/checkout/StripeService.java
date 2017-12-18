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

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinSession;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 * Spring Service which interacts with Stripe's server to validate payments and store data into our personal cloud space.
 * @author jaycaves
 */
@Service
public class StripeService {

    //@Value("${STRIPE_SECRET_KEY}")
    private String secretKey = "sk_test_RuQWeP6fRFKs0DbXl8tSkCEi";

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, CardException, APIException {

        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", chargeRequest.getStripeEmail());
        customerParams.put("description", "Customer: " + chargeRequest.getStripeEmail());
        customerParams.put("source", chargeRequest.getStripeToken());
        Customer customer = Customer.create(customerParams);
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", "usd");
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("customer", customer.getId());

        return Charge.create(chargeParams);
    }

    private Customer customerCheck(ChargeRequest chargeRequest) {

        //query per salvare customer.id, use your
        return null;
    }
    
    private void customerDbSave(){
        //wait for query
        
    }
}
