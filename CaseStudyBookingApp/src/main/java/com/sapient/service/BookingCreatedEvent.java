package com.sapient.service;

import java.util.List;
import java.util.Map;

public class BookingCreatedEvent {
	
	Long bookingId;
	Double paymentAmount;

	Map<String, List<String>> seats;
	
	String theatreId;

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

	public Map<String, List<String>> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, List<String>> seats) {
		this.seats = seats;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public BookingCreatedEvent(Long bookingId, Double paymentAmount, Map<String, List<String>> seats,
			String theatreId) {
		super();
		this.bookingId = bookingId;
		this.paymentAmount = paymentAmount;
		this.seats = seats;
		this.theatreId = theatreId;
	}
	
	
	

}
