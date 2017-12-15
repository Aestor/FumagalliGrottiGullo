/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.travlendar.ui.pages;

import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author jaycaves
 */

public class WelcomePage extends VerticalLayout{

     public static final String NAME = "Welcome";
    
   public WelcomePage(){
   
   Notification.show("WELCOME, YOU'RE NOW OUR BITCH");
   
   }
     
     
}
