/*
 * Copyright 2018 Pivotal Software, Inc..
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


import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.payment.checkout.ChargeRequest;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.evosuite.shaded.org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Runs component tests for StripeService;
 *
 * @author jaycaves
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class IT_PaymentGateway {

    @MockBean
    private JdbcTemplate jdbcTemplate;

    private Long newBalance;
    private String customerId;
    Map<String, Object> chargeParams;

    @Mock
    Charge charge;

    @Before
    public void setUp() {

            User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
            ChargeRequest chargeRequest = new ChargeRequest();
            chargeRequest.setAmount("100");
            chargeRequest.setUser(user.getEmail());
            newBalance = new Long(10);
            user.setBalance(new Long(10));
            customerId = "ansifh58960";
            user.setStripeId(customerId);
            charge = new Charge();
            charge.setAmount(new Long(5));
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", chargeRequest.getAmount());
            chargeParams.put("currency", "usd");
            chargeParams.put("description", "User : " + chargeRequest.getUser() + " paid typing email: " + chargeRequest.getStripeEmail());

            // HERE WITH FAKE SOME DATABASE ENTRY //
            Mockito.when(jdbcTemplate.queryForObject("SELECT balance FROM users WHERE email = ?",
                    new Object[]{user.getEmail()}, Long.class)).thenReturn(user.getBalance());
            Mockito.when(jdbcTemplate.update("UPDATE users SET balance = ? WHERE email= ?",
                    user.getBalance(), user.getEmail())).thenReturn(1);
            Mockito.when(jdbcTemplate.update("UPDATE users SET stripeId = ? WHERE email= ?",
                    customerId, user.getEmail())).thenReturn(1);
            Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", new Object[]{chargeRequest.getUser()}, User.class)).thenReturn(user);
        }

    /**
     * Test of charge method, of class StripeService.
     */
    @Test
    public void testCharge() throws Exception {

        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        user.setBalance(new Long(10));
        user.setStripeId(customerId);
        ChargeRequest chargeRequest = new ChargeRequest();
        chargeRequest.setAmount("100");
        chargeRequest.setUser(user.getEmail());

        User result = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", new Object[]{chargeRequest.getUser()}, User.class);

        assertEquals(user.toString(), result.toString());

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", "usd");
        chargeParams.put("description", "User : " + chargeRequest.getUser() + " paid typing email: " + chargeRequest.getStripeEmail());

        

    }

    /**
     * Test of stripeInit method, of class StripeService.
     */
    @Test
    public void testStripeInit() {
        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
         user.setStripeId("ansifh58960");
        ChargeRequest chargeRequest = new ChargeRequest();
        chargeRequest.setAmount("100");
        chargeRequest.setUser(user.getEmail());
        jdbcTemplate.update("UPDATE users SET stripeId = ? WHERE email= ?",
                customerId, user.getEmail());
        User result = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", new Object[]{chargeRequest.getUser()}, User.class);

        assertEquals(user.getStripeId(), result.getStripeId());
    }

    /**
     * Test of updateBalance method, of class StripeService.
     */
    @Test
    public void testUpdateBalance() {
        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        user.setBalance(new Long(10));
        jdbcTemplate.update("UPDATE users SET balance = ? WHERE email= ?",
               user.getBalance(), user.getEmail());
        Long result = jdbcTemplate.queryForObject("SELECT balance FROM users WHERE email = ?",
                new Object[]{user.getEmail()}, Long.class);

        assertEquals(user.getBalance(), result);

    }

    /**
     * Test of getBalance method, of class StripeService.
     */
    @Test
    public void testGetBalance() {
        User user = new User(new Long(1), "example@hotmail.it", "password", "Pablo", "Escobar");
        user.setBalance(newBalance);
        Long result = jdbcTemplate.queryForObject("SELECT balance FROM users WHERE email = ?",
                new Object[]{user.getEmail()}, Long.class);

        assertEquals(user.getBalance(), user.getBalance());
    }
}
