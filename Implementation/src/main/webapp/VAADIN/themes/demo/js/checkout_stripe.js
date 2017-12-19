
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
        scriptEl.setAttribute("data-zip-code", "false");
        scriptEl.setAttribute("data-currency", "usd");
        scriptEl.setAttribute("class", "stripe-button");
        

        return scriptEl;
    }

    me.onStateChange = function () {
        // remove existing script
        var child = me.formElement.firstChild;
        if (child) {
            me.formElement.removeChild(child);
        }
        
        //pass amount parameter
        var x = document.createElement("INPUT");
        x.setAttribute("type", "hidden");
        x.setAttribute("value", me.getState().amount);
        x.setAttribute("name", "amount");
        me.formElement.append(x);
        
        //pass user parameter
        var y = document.createElement("INPUT");
        y.setAttribute("type", "hidden");
        y.setAttribute("value", me.getState().user);
        y.setAttribute("name", "user");
        me.formElement.append(y);
        
        // add script tag as form child
        me.formElement.appendChild(makeScriptTag(me.getState()));
    }




}



