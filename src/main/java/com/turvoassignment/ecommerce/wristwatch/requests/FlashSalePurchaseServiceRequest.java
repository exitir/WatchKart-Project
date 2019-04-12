package com.turvoassignment.ecommerce.wristwatch.requests;

import com.turvoassignment.ecommerce.wristwatch.models.WatchRequestWrapper;

import java.util.List;

public class FlashSalePurchaseServiceRequest {

    private String flashSaleId;
    private String userId;
    private List<WatchRequestWrapper> watchesWithQty;

    public String getFlashSaleId() {
        return flashSaleId;
    }

    public void setFlashSaleId(String flashSaleId) {
        this.flashSaleId = flashSaleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<WatchRequestWrapper> getWatchesWithQty() {
        return watchesWithQty;
    }

    public void setWatchesWithQty(List<WatchRequestWrapper> watchesWithQty) {
        this.watchesWithQty = watchesWithQty;
    }
}
