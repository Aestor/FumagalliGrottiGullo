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
package com.polimi.travlendar.backend.beans;

import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.backend.database.UserRowMapper;
import com.polimi.travlendar.payment.checkout.ChargeRequest;
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
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Spring Service which interacts with Stripe's server to validate payments and
 * store data into our personal cloud space.
 *
 * @author jaycaves
 */
@Service
@Scope("session")
public class StripeService {

    private final String secretKey = "sk_test_RuQWeP6fRFKs0DbXl8tSkCEi";
    private boolean firstPayment;
    
    @Autowired
    User user;
    
    @Autowired
    private JdbcTemplate jdbcTemplate ;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
        
        
    }

    public Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, CardException, APIException {

        user = (User) jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", new Object[]{chargeRequest.getUser()}, new UserRowMapper());
        Customer customer = customerInit(chargeRequest);

        if (firstPayment) // MUST REGISTER IN DB //
        {
            stripeInit(customer.getId());
        }

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", "usd");
        chargeParams.put("description", "User : " + chargeRequest.getUser() + " paid typing email: " + chargeRequest.getStripeEmail());
        chargeParams.put("customer", customer.getId());

        return Charge.create(chargeParams);
    }
 
    
    private Customer customerInit(ChargeRequest chargeRequest) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {

        if (user.getStripeId().equals("none")) {

            // FIRST PAYMENT FOR THE CURRENT USER, MUST REGISTER HIM AS CUSTOMER //
            Map<String, Object> customerParams = new HashMap<>();
            customerParams.put("email", chargeRequest.getUser());
            customerParams.put("description", "Travlendar User with id: #" + user.getId());
            customerParams.put("source", chargeRequest.getStripeToken());
            firstPayment = true;
            return Customer.create(customerParams);
        }
        
        firstPayment = false;
        return Customer.retrieve(user.getStripeId());

    }
    
     /**
     *  Writes the Stripe unique Customer code in the DB.
     * @param customerId 
     */
    public void stripeInit(String customerId) {

        jdbcTemplate.update("UPDATE users SET stripeId = ? WHERE email= ?",
                customerId, user.getEmail());

        user.setStripeId(customerId);

    }

    
    
    /**
     * Writes the new balance in the DB.
     * @param newBalance 
     */
    public void updateBalance(Long newBalance) {

        jdbcTemplate.update("UPDATE users SET balance = ? WHERE email= ?",
                newBalance, user.getEmail());

        user.setBalance(newBalance);
        
    }
    
    /**
     * Fetches user's balance from db
     * @return 
     */
    public Long getBalance() {
        return (Long) jdbcTemplate.queryForObject("SELECT balance FROM users WHERE email = ?",
                    new Object[]{user.getEmail()}, Long.class);
    }
    

}
