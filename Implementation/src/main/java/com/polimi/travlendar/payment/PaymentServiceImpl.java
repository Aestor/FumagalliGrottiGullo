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
package com.polimi.travlendar.payment;

import com.polimi.travlendar.payment.checkout.ChargeRequest;
import com.polimi.travlendar.User;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jaycaves
 */
@SpringComponent("paymentService")
@VaadinSessionScope
@Scope("session")
public class PaymentServiceImpl implements PaymentService {

    //@Value("${STRIPE_SECRET_KEY}")
    private String STRIPE_SECRET_KEY = "pk_test_Br0eRZUzudfg2GZQWZVAJxju";

    

    @Override
    public String createCustomer(User user) {

        Map<String, Object> customerParams = new HashMap<>();
        customerParams.put("description",
                user.getFirst_name() + " " + user.getLast_name());
        customerParams.put("email", user.getEmail());

        String id = null;

        try {
            // Create customer
            Customer stripeCustomer = Customer.create(customerParams);
            id = stripeCustomer.getId();
            System.out.println(stripeCustomer);
        } catch (CardException e) {
            // Transaction failure
        } catch (RateLimitException e) {
            // Too many requests made to the API too quickly
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
        } catch (AuthenticationException | APIConnectionException e) {
            // Authentication with Stripe's API failed (wrong API key?)
        } // Network communication with Stripe failed
        catch (StripeException e) {
            // Generic error
        } catch (Exception e) {
            // Something else happened unrelated to Stripe
        }

        return id;
    }

    @Override
    public void chargeCreditCard(ChargeRequest chargeRequest) {

        // Stripe requires the charge amount to be in cents
        //int chargeAmountCents = (int) chargeRequest.getAmount(). * 100;

        //User user = chargeRequest.getUser();

        Map<String, Object> chargeParams = new HashMap<String, Object>();
     //   chargeParams.put("amount", chargeAmountCents);
        chargeParams.put("currency", "eur");
        chargeParams.put("description", "Monthly Charges");
        //chargeParams.put("customer", user.getStripeId());
      //  chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());

        try {
            // Submit charge to credit card 
            Charge charge = Charge.create(chargeParams);
            System.out.println(charge);
        } catch (CardException e) {
            // Transaction was declined
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getMessage());
        } catch (RateLimitException e) {
            // Too many requests made to the API too quickly
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
        } catch (AuthenticationException e) {
            // Authentication with Stripe's API failed (wrong API key?)
        } catch (APIConnectionException e) {
            // Network communication with Stripe failed
        } catch (StripeException e) {
            // Generic error
        } catch (Exception e) {
            // Something else happened unrelated to Stripe
        }

    }
    
    
    

}
