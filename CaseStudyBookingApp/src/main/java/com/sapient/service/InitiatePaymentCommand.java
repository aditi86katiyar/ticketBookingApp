package com.sapient.service;

import java.util.List;

public class InitiatePaymentCommand {
	
	String bookingId;
	Double paymentAmount;
	List<String> seats;
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public InitiatePaymentCommand(String bookingId, Double paymentAmount) {
		super();
		this.bookingId = bookingId;
		this.paymentAmount = paymentAmount;
	}
	
	

}
