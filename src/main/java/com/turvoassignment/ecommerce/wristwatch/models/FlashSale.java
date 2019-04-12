package com.turvoassignment.ecommerce.wristwatch.models;

import java.util.Date;
import java.util.List;

public class FlashSale {
	private String flashSaleId;
	private Date date;
	private Time timeStart;
	private int duration; // hours
	private List<String> watchIdsOnSale; // contains watchId of all watches which are on sale
	private List<String> registeredUserIds; // contains userIds of all users who have registered

	public String getFlashSaleId() {
		return flashSaleId;
	}

	public void setFlashSaleId(String flashSaleId) {
		this.flashSaleId = flashSaleId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<String> getWatchIdsOnSale() {
		return watchIdsOnSale;
	}

	public void setWatchIdsOnSale(List<String> watchIdsOnSale) {
		this.watchIdsOnSale = watchIdsOnSale;
	}

	public List<String> getRegisteredUserIds() {
		return registeredUserIds;
	}

	public void setRegisteredUserIds(List<String> registeredUserIds) {
		this.registeredUserIds = registeredUserIds;
	}

}
