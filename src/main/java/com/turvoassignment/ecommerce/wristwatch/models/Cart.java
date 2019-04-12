package com.turvoassignment.ecommerce.wristwatch.models;

import java.util.List;

/**
 * Created by Irfan on 22-Feb-19.
 */
public class Cart {
    private List<CartEntry> cartEntries;
    private double serviceTax = 5; //assumption: 5 percentage

    public double getCartAmount() {
        double cartAmount = 0.0d;
        for (CartEntry ce : cartEntries) {
            cartAmount += ce.getCartEntryAmount();
        }
        cartAmount += cartAmount * 0.05;
        return cartAmount;
    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }

    public void setCartEntries(List<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }
}
