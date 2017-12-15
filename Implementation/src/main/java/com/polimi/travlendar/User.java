package com.polimi.travlendar;

import org.springframework.context.annotation.Scope;

import com.polimi.travlendar.user.UserSettings;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;

/**
 * This object can be injected in a user session to store the information about
 * the logged user.
 *
 * @author Emmeggi95
 * @author jaycaves
 *
 */
@SpringComponent
@VaadinSessionScope
@Scope("session")
public class User {

    private Long id;
    private String email, password, first_name, last_name;
    private UserSettings settings;
    private Long balance;
    private String stripeId;

    public User(Long id, String email, String password, String first_name, String last_name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public User(String email, String password, String first_name, String last_name) {
        this.id = new Long(-1);
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public User(String email, String password) {
        this.id = new Long(-1);
        this.email = email;
        this.password = password;
        this.first_name = "";
        this.last_name = "";
    }

    public User() {
        this.id = new Long(-1);
        this.email = "";
        this.password = "";
        this.first_name = "";
        this.last_name = "";
    }

    /**
     * Use this method to fill the autowired object User's attributes
     *
     * @param other
     */
    public void setUser(User other) {
        this.id = other.id;
        this.email = other.email;
        this.password = other.password;
        this.first_name = other.first_name;
        this.last_name = other.last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

}
