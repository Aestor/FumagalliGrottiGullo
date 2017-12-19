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

import com.polimi.travlendar.ui.pages.BalancePage;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ChargeController extends VerticalLayout implements View {

    @Autowired
    private StripeService paymentsService;

    private String htmlResponse = "<html xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>\n"
            + "    <head>\n"
            + "        <title>Result</title>\n"
            + "    </head>\n"
            + "    <body>\n"
            + "        <h3 th:if='${error}' th:text='${error}' style='color: red;'></h3>\n"
            + "        <div th:unless='${error}'>\n"
            + "            <h3 style='color: green;'>Success!</h3>\n"
            + "            <div>Id.: <span th:text='${id}' /></div>\n"
            + "            <div>Status: <span th:text='${status}' /></div>\n"
            + "            <div>Charge id.: <span th:text='${chargeId}' /></div>\n"
            + "            <div>Balance transaction id.: <span th:text='${balance_transaction}' /></div>\n"
            + "        </div>\n"
            + "        <a href='/#!" + BalancePage.NAME + "'>Checkout again</a>\n"
            + "    </body>\n"
            + "</html>";

    @RequestMapping("/charge")
    public String charge(ChargeRequest chargeRequest)
            throws StripeException {
        chargeRequest.setDescription("Charge");
        Charge charge = paymentsService.charge(chargeRequest);
        paymentsService.customerBalanceUpdate(charge);
        return htmlResponse;
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        System.err.println(ex.getMessage());
        return htmlResponse;
    }

}
