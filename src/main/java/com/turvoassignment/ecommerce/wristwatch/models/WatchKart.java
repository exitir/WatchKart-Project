package com.turvoassignment.ecommerce.wristwatch.models;

import java.util.ArrayList;
import java.util.List;

import com.turvoassignment.ecommerce.wristwatch.util.WatchKartUtil;

public class WatchKart {

    private static WatchKart _watchkart = null; // Singleton instance of WatchKart
    private List<User> users;
    private List<Watch> watchs;
    private List<FlashSale> flashSales;
    private List<PurchaseOrder> purchaseOrders;

    private WatchKart() {

    }

    public static WatchKart getWatchKartInstance() {
        if (_watchkart == null) {
            _watchkart = new WatchKart();
            _watchkart.users = new ArrayList();
            _watchkart.watchs = new ArrayList();
            _watchkart.flashSales = new ArrayList();
            _watchkart.purchaseOrders = new ArrayList();
            WatchKartUtil.initializeTheWatchKartCompany(_watchkart);
        }
        return _watchkart;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Watch> getWatchs() {
        return watchs;
    }

    public void setWatchs(List<Watch> watchs) {
        this.watchs = watchs;
    }

    public List<FlashSale> getFlashSales() {
        return flashSales;
    }

    public void setFlashSales(List<FlashSale> flashSales) {
        this.flashSales = flashSales;
    }

}
