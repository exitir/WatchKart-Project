package com.turvoassignment.ecommerce.wristwatch.response;

import com.turvoassignment.ecommerce.wristwatch.models.PurchaseOrder;
import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;

public class FlashSalePurchaseServiceResponse {

	private ResponseEnum res;
	private String message;
	private PurchaseOrder purchaseOrder;

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

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

}
