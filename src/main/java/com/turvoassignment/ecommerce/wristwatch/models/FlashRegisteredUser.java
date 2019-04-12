package com.turvoassignment.ecommerce.wristwatch.models;

import java.util.Date;

public class FlashRegisteredUser extends User {
	private boolean registrationCompleted;
	private Date registrationDate;
	private Time registrationTime;

	public boolean isRegistrationCompleted() {
		return registrationCompleted;
	}

	public void setRegistrationCompleted(boolean registrationCompleted) {
		this.registrationCompleted = registrationCompleted;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Time getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Time registrationTime) {
		this.registrationTime = registrationTime;
	}

}
