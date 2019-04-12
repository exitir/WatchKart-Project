package com.turvoassignment.ecommerce.wristwatch.response;

import java.util.List;

import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.models.Watch;

public class FlashSaleBrowserServiceResponse {

	ResponseEnum res;
	String message;
	List<Watch> watches;

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

	public List<Watch> getWatches() {
		return watches;
	}

	public void setWatches(List<Watch> watches) {
		this.watches = watches;
	}

}
