package com.turvoassignment.ecommerce.wristwatch.models;

/**
 * Created by Irfan on 22-Feb-19.
 */
public class CartEntry {
    Watch watch;
    int quantity;

    public double getCartEntryAmount() {
        return watch.getPrice() * quantity;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
