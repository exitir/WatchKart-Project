package com.turvoassignment.ecommerce.wristwatch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.requests.FlashSaleRegistrationServiceRequest;
import com.turvoassignment.ecommerce.wristwatch.response.FlashSaleRegistrationServiceResponse;
import com.turvoassignment.ecommerce.wristwatch.util.WatchKartUtil;

@RestController
public class FlashSaleRegistrationService {

    private static Logger logger = LoggerFactory.getLogger(FlashSaleRegistrationService.class);

    @Autowired
    WatchKartDaoService watchKartDaoService;

    @PostMapping("/registerForFlashSale")
    public FlashSaleRegistrationServiceResponse registerFlashUser(@RequestBody FlashSaleRegistrationServiceRequest request) {
        if (request != null) {
            try {
                watchKartDaoService.registerFlashUser(request.getUserId(), request.getFlashSaleId());
            } catch (Exception e) {
                logger.error(e.getMessage());
                return buildResponse(ResponseEnum.FAILURE, e.getMessage());
            }
        }
        return buildResponse(ResponseEnum.SUCCESS,
                String.format("User: %s successfully regisgtered for flashsale: %s.", request.getUserId(), request.getFlashSaleId()));
    }

    public FlashSaleRegistrationServiceResponse buildResponse(ResponseEnum res, String msg) {

        FlashSaleRegistrationServiceResponse response = new FlashSaleRegistrationServiceResponse();
        response.setRes(res);
        response.setMessage(msg);
        return response;

    }

}
