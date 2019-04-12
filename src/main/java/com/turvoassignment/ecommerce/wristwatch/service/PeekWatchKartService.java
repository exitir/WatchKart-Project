package com.turvoassignment.ecommerce.wristwatch.service;

import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.models.WatchKart;
import com.turvoassignment.ecommerce.wristwatch.requests.PeekWatchKartServiceRequest;
import com.turvoassignment.ecommerce.wristwatch.response.PeekWatchKartServiceResponse;
import com.turvoassignment.ecommerce.wristwatch.util.WatchKartUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeekWatchKartService {
    private static Logger logger = LoggerFactory.getLogger(PeekWatchKartService.class);


    @Autowired
    WatchKartDaoService watchKartDaoService;

    @PostMapping("/peekwatchkart")
    public PeekWatchKartServiceResponse seeWatchKart(@RequestBody PeekWatchKartServiceRequest request) {
        WatchKart watchKart = null;
        try {
            watchKart = watchKartDaoService.peekWatchKart(
                    request.getUserId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return buildResponse(ResponseEnum.FAILURE, e.getMessage(), watchKart);
        }
        return buildResponse(ResponseEnum.SUCCESS, "WatchKart details fetched successfully.", watchKart);

    }

    private PeekWatchKartServiceResponse buildResponse(ResponseEnum res, String message, WatchKart watchKart) {
        PeekWatchKartServiceResponse peekWatchKartServiceResponse = new PeekWatchKartServiceResponse();
        peekWatchKartServiceResponse.setMessage(message);
        peekWatchKartServiceResponse.setRes(res);
        peekWatchKartServiceResponse.setWatchKart(watchKart);
        return peekWatchKartServiceResponse;
    }

}
