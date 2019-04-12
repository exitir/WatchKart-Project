package com.turvoassignment.ecommerce.wristwatch.models;

public class Time {
	private int hh;// 24 hour format expected
	private int mm;
	private int ss;

	public Time(int hh, int mm, int ss) {
		super();
		this.hh = hh;
		this.mm = mm;
		this.ss = ss;
	}

	public int compare(Time time2) { // if time2 is greater return 1, if equal return 0 else return -1

		if (time2.getHh() * 3600 + time2.getMm() * 60 + time2.getSs() > hh * 3600 + mm * 60 + ss)
			return 1;

		else if (time2.getHh() * 3600 + time2.getMm() * 60 + time2.getSs() == hh * 3600 + mm * 60 + ss)
			return 0;

		else
			return -1;

	}

	public int getHh() {
		return hh;
	}

	public void setHh(int hh) {
		this.hh = hh;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getSs() {
		return ss;
	}

	public void setSs(int ss) {
		this.ss = ss;
	}

}
