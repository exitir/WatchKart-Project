package com.turvoassignment.ecommerce.wristwatch.response;

import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.models.WatchKart;

public class FlashSaleRegistrationServiceResponse {
    ResponseEnum res;
    String message;

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

}
