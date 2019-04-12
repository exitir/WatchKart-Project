package com.turvoassignment.ecommerce.wristwatch.requests;

import com.turvoassignment.ecommerce.wristwatch.models.User;

public class FlashSaleRegistrationServiceRequest {
	private String flashSaleId;
	private String userId;

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

}
