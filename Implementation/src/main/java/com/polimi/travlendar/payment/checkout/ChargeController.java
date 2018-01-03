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

import com.polimi.travlendar.backend.beans.StripeService;
import com.polimi.travlendar.frontend.ui.pages.BalancePage;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Here Checkout's response is handled and transaction is started.
 *
 * @author jaycaves
 */
@RestController
@Scope("session")
public class ChargeController extends VerticalLayout implements View {

    @Autowired
    private StripeService paymentsService;

    @RequestMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
            throws StripeException {
        
        Charge charge = paymentsService.charge(chargeRequest);
        paymentsService.updateBalance(charge.getAmount()/100);
        return "<html xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>\n"
                + "    <head>\n"
                + "        <title>Result</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div >\n"
                + "            <h3 style='color: green;'>Success!</h3>\n"
                + "            <div>User: " + chargeRequest.getUser() + "</div>\n"
                + "            <div>Status: " + charge.getStatus() + "</div>\n"
                + "            <div>Charge id.: " + charge.getId() + "</div>\n"
                + "            <div>Balance transaction id.: " + charge.getBalanceTransaction() + "</div>\n"
                + "        </div>\n"
                + "         <br><br>"
                + "        <a href='/#!" + BalancePage.NAME + "'>Go back to the app </a>\n"
                + "    </body>\n"
                + "</html>";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "<html xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>\n"
                + "    <head>\n"
                + "        <title>Result</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div >\n"
                + "            <h3 style='color: red;'>Failure</h3>\n"
                + "         <div>The following error occurred: <br> " + ex.getMessage() + "</div>\n"
                + "        </div>\n"
                + "         <br><br>"
                + "        <a href='/#!" + BalancePage.NAME + "'>Checkout again</a>\n"
                + "    </body>\n"
                + "</html>";
    }

}
