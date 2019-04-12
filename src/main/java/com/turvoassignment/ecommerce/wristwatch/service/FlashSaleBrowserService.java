package com.turvoassignment.ecommerce.wristwatch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.models.Watch;
import com.turvoassignment.ecommerce.wristwatch.requests.FlashSaleBrowserServiceRequest;
import com.turvoassignment.ecommerce.wristwatch.response.FlashSaleBrowserServiceResponse;
import com.turvoassignment.ecommerce.wristwatch.util.WatchKartUtil;

@RestController
public class FlashSaleBrowserService {

	private static Logger logger = LoggerFactory.getLogger(FlashSaleBrowserService.class);

	@Autowired
	WatchKartDaoService watchKartDaoService;

	@PostMapping("/browseFlashSale")
	public FlashSaleBrowserServiceResponse getAllWatchesOnFlashSale(
			@RequestBody FlashSaleBrowserServiceRequest request) {
		try {
			// user is not registered
			if (!watchKartDaoService.checkIfUserRegisteredForFlashSale(request.getUserId(), request.getFlashSaleId())) {
				return buildBroswerResponse(ResponseEnum.FAILURE, null,
						String.format("User: %s has not registered yet for the flashsale: %s", request.getUserId(),
								request.getFlashSaleId()));
			}

			// user should get the list of watches currently on the flash sales
			return buildBroswerResponse(ResponseEnum.SUCCESS,
					watchKartDaoService.getAllWatchesOnFlashSales(request.getFlashSaleId()),
					"Watches on Flash Sales are found successfully.");

		} catch (Exception e) {
			logger.error(e.getMessage());
			return buildBroswerResponse(ResponseEnum.FAILURE, null, e.getMessage());
		}

	}

	private FlashSaleBrowserServiceResponse buildBroswerResponse(ResponseEnum res, List<Watch> watches,
			String message) {
		FlashSaleBrowserServiceResponse response = new FlashSaleBrowserServiceResponse();
		response.setRes(res);
		response.setMessage(message);
		response.setWatches(watches);
		return response;
	}

}
