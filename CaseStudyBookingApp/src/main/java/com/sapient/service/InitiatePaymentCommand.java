package com.sapient.service;

public class InitiatePaymentCommand {
	
	Long bookingId;
	Double paymentAmount;
	
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public InitiatePaymentCommand(Long bookingId, Double paymentAmount) {
		super();
		this.bookingId = bookingId;
		this.paymentAmount = paymentAmount;
	}
	
	

}
