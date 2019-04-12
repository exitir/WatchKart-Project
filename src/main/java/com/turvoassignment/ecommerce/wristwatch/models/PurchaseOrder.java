package com.turvoassignment.ecommerce.wristwatch.models;

public class PurchaseOrder {

    private String orderId;
    private String userId;
    private Cart cart;
    private OrderStatusEnum orderStatus;
    private double orderBillingAmount;

    public double getOrderBillingAmount() {
        return orderBillingAmount;
    }

    public void setOrderBillingAmount(double orderBillingAmount) {
        this.orderBillingAmount = orderBillingAmount;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
