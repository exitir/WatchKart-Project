package com.turvoassignment.ecommerce.wristwatch.response;

import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.models.WatchKart;

/**
 * Created by Irfan on 22-Feb-19.
 */
public class PeekWatchKartServiceResponse {

    private ResponseEnum res;
    private String message;
    private WatchKart watchKart;

    public ResponseEnum getRes() {
        return res;
    }

    public void setRes(ResponseEnum res) {
        this.res = res;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WatchKart getWatchKart() {
        return watchKart;
    }

    public void setWatchKart(WatchKart watchKart) {
        this.watchKart = watchKart;
    }
}
