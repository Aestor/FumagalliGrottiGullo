 var me = this;
    me.formElement = document.createElement("form");
    me.formElement.setAttribute("action", "");
    me.formElement.setAttribute("method", "POST");

    // add form to javascript component element
    me.getElement().appendChild(me.formElement);

    // create a new script tag with attributes from state
    var makeScriptTag = function (state) {
        var scriptEl = document.createElement("script");
        scriptEl.setAttribute("src", "https://checkout.stripe.com/checkout.js");
        scriptEl.setAttribute("data-key", state.key);
        scriptEl.setAttribute("data-amount", state.amount);
        scriptEl.setAttribute("data-description", "Travlendar");
        scriptEl.setAttribute("data-image", "https://stripe.com/img/documentation/checkout/marketplace.png");
        scriptEl.setAttribute("data-locale", "auto");
        scriptEl.setAttribute("data-zip-code", "true");
        scriptEl.setAttribute("data-currency", "eur");
        scriptEl.setAttribute("class", "stripe-button");

        return scriptEl;
    }

    me.onStateChange = function () {
        // remove existing script
        var child = me.formElement.firstChild;
        if (child) {
            me.formElement.removeChild(child);
        }
        // add script tag as form child
        me.formElement.appendChild(makeScriptTag(me.getState()));
        
    }

    /*
     var stripe = require("stripe")("sk_test_RuQWeP6fRFKs0DbXl8tSkCEi");
     
     // Token is created using Checkout or Elements!
     // Get the payment token ID submitted by the form:
     var token = scriptEl.getAttribute("stripeToken");
     var email = scriptEl.getAttribute("stripeEmail");
     // Create a Customer:
     stripe.customers.create({
     email: email,
     source: token,
     }).then(function (customer) {
     // YOUR CODE: Save the customer ID and other info in a database for later.
     return stripe.charges.create({
     amount: state.amount,
     currency: "eur",
     customer: customer.id,
     });
     }).then(function (charge) {
     // Use and save the charge info.
     });
     
     // YOUR CODE (LATER): When it's time to charge the customer again, retrieve the customer ID.
     stripe.charges.create({
     amount: state.amount, // $15.00 this time
     currency: "eur",
     customer: customerId,
     });
     */

    /* var scriptEl = document.createElement("script");
     scriptEl.setAttribute("src", "https://checkout.stripe.com/checkout.js");
     
     document.getElementById("cardform").innerHTML ="<button id='customButton'>"
     + "Purchase" 
     + "</button>";
     
     
     var handler = StripeCheckout.configure({
     key: 'pk_test_Br0eRZUzudfg2GZQWZVAJxju',
     image: 'https://stripe.com/img/documentation/checkout/marketplace.png',
     locale: 'auto',
     token: function (token) {
     // You can access the token ID with `token.id`.
     // Get the token ID to your server-side code for use.
     }
     });
     
     document.getElementById('customButton').addEventListener('click', function (e) {
     // Open Checkout with further options:
     handler.open({
     name: 'Travlendar+',
     description: '2 widgets',
     zipCode: true,
     amount: 2000
     });
     e.preventDefault();
     });
     
     // Close Checkout on page navigation:
     window.addEventListener('popstate', function () {
     handler.close();
     });
     } */
