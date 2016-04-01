package com.yas.talentshowvotingapp.model;

import java.util.Date;

public class Vote {

	private Date recivedDateTime;
	private String senderNumber;
	private String text;

	public Vote(Date recivedDateTime, String senderNumber, String text) {
		super();
		this.recivedDateTime = recivedDateTime;
		this.senderNumber = senderNumber;
		this.text = text;
	}

	public Date getRecivedDateTime() {
		return recivedDateTime;
	}

	public void setRecivedDateTime(Date recivedDateTime) {
		this.recivedDateTime = recivedDateTime;
	}

	public String getSenderNumber() {
		return senderNumber;
	}

	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
