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

import com.polimi.travlendar.UserService;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Spring Service which interacts with Stripe's server to validate payments and
 * store data into our personal cloud space.
 *
 * @author jaycaves
 */
@Service
public class StripeService {

    private String secretKey = "sk_test_RuQWeP6fRFKs0DbXl8tSkCEi";
    
    @Autowired 
    UserService user; 

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    protected Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, CardException, APIException {

        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", chargeRequest.getUser());
        customerParams.put("description", "User : " + chargeRequest.getUser() + " paid with email: " + chargeRequest.getStripeEmail());
        customerParams.put("source", chargeRequest.getStripeToken());
        Customer customer = Customer.create(customerParams);
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", "usd");
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("customer", customer.getId());

        return Charge.create(chargeParams);
    }

    protected void customerBalanceUpdate(Charge charge) {
            
    }

    private Customer customerCheck(ChargeRequest chargeRequest) {

        //query per salvare customer.id, use your
        return null;
    }

    private void customerDbSave() {
        //wait for query

    }

}
