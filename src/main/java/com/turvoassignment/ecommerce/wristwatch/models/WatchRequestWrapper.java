package com.turvoassignment.ecommerce.wristwatch.models;

/**
 * Created by Irfan on 22-Feb-19.
 */
public class WatchRequestWrapper {
    String watchId;
    int quantity;

    public String getWatchId() {
        return watchId;
    }

    public void setWatchId(String watchId) {
        this.watchId = watchId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
