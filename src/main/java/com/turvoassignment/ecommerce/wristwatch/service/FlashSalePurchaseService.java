package com.turvoassignment.ecommerce.wristwatch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvoassignment.ecommerce.wristwatch.models.PurchaseOrder;
import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.models.Watch;
import com.turvoassignment.ecommerce.wristwatch.requests.FlashSalePurchaseServiceRequest;
import com.turvoassignment.ecommerce.wristwatch.response.FlashSaleBrowserServiceResponse;
import com.turvoassignment.ecommerce.wristwatch.response.FlashSalePurchaseServiceResponse;

@RestController
public class FlashSalePurchaseService {

    private static Logger logger = LoggerFactory.getLogger(FlashSalePurchaseService.class);

    @Autowired
    WatchKartDaoService watchKartDaoService;

    @PostMapping("/purchaseWatch")
    public FlashSalePurchaseServiceResponse purchaseWatch(@RequestBody FlashSalePurchaseServiceRequest request) {
        PurchaseOrder purchaseOrder = null;
        try {
            // user is not registered
            if (!watchKartDaoService.checkIfUserRegisteredForFlashSale(request.getUserId(), request.getFlashSaleId())) {
                return buildBroswerResponse(ResponseEnum.FAILURE,
                        String.format("User: %s has not registered yet for the flashsale: %s", request.getUserId(),
                                request.getFlashSaleId()),
                        null);
            }
            // create a purchase order and add to the watchkart and User
            purchaseOrder = watchKartDaoService.createPurchaseOrder(request);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return buildBroswerResponse(ResponseEnum.FAILURE, e.getMessage(), null);
        }
        return buildBroswerResponse(ResponseEnum.SUCCESS, "Order placed successfully.", purchaseOrder);

    }

    private FlashSalePurchaseServiceResponse buildBroswerResponse(ResponseEnum res, String message,
                                                                  PurchaseOrder purchaseOrder) {

        FlashSalePurchaseServiceResponse response = new FlashSalePurchaseServiceResponse();
        response.setMessage(message);
        response.setPurchaseOrder(purchaseOrder);
        response.setRes(res);
        return response;

    }

}
