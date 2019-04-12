package com.turvoassignment.ecommerce.wristwatch.requests;

public class FlashSaleBrowserServiceRequest {

	private String userId;
	private String flashSaleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFlashSaleId() {
		return flashSaleId;
	}

	public void setFlashSaleId(String flashSaleId) {
		this.flashSaleId = flashSaleId;
	}

}
