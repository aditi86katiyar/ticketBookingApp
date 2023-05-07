package com.sapient.service;

import java.util.List;
import java.util.Map;

public class InitiatePaymentCommand {
	
	String bookingId;
	Double paymentAmount;
	Map<String, List<String>> seats;
	
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
	public Map<String, List<String>> getSeats() {
		return seats;
	}
	public void setSeats(Map<String, List<String>> seats) {
		this.seats = seats;
	}
	public InitiatePaymentCommand(String bookingId, Double paymentAmount, Map<String, List<String>> seats) {
		super();
		this.bookingId = bookingId;
		this.paymentAmount = paymentAmount;
		this.seats = seats;
	}
	
	
	
	

}
