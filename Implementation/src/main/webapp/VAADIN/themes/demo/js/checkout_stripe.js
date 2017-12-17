
com_polimi_travlendar_payment_checkout_CheckoutJs = function () {

    var me = this;
    

    me.formElement = document.createElement("form");
    me.formElement.setAttribute("action", "/charge");
    me.formElement.setAttribute("method", "POST");

    // add form to javascript component element
    me.getElement().appendChild(me.formElement);

    // create a new script tag with attributes from state
    var makeScriptTag = function (state) {
        var scriptEl = document.createElement("script");
        scriptEl.setAttribute("src", "https://checkout.stripe.com/checkout.js");
        scriptEl.setAttribute("data-key", state.key);
        scriptEl.setAttribute("data-amount", state.amount);
        scriptEl.setAttribute("data-description", "Travlendar+");
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

    


}



