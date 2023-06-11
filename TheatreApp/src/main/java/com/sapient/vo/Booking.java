package com.sapient.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonProperty;


public class Booking {
	
	
	String id;
	
	String userId;
	
	String theatreId;
	
   Map<String, List<String>> seats;

    double totalPrice;
    
    int numberOfTickets;
	
	Date bookedDate;
	
    private Date showTime;
  
    private String paymentMethod;
   
    BookingType bookingType;

		public Map<String, List<String>> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, List<String>> seats) {
		this.seats = seats;
	}

		public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	
	

	public BookingType getBookingType() {
		return bookingType;
	}

	public void setBookingType(BookingType bookingType) {
		this.bookingType = bookingType;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String uuid) {
		this.id = uuid;
	}
	
	public Booking() {}

	public Booking(String userId, String theatreId, Map<String, List<String>> seats, double totalPrice,
			int numberOfTickets, Date bookedDate, Date showTime, String paymentMethod, BookingType bookingType) {
		super();
		this.userId = userId;
		this.theatreId = theatreId;
		this.seats = seats;
		this.totalPrice = totalPrice;
		this.numberOfTickets = numberOfTickets;
		this.bookedDate = bookedDate;
		this.showTime = showTime;
		this.paymentMethod = paymentMethod;
		this.bookingType = bookingType;
	}

	public Booking(String id, String userId, String theatreId, Map<String, List<String>> seats, double totalPrice,
			int numberOfTickets, Date bookedDate, Date showTime, String paymentMethod, BookingType bookingType) {
		super();
		this.id = id;
		this.userId = userId;
		this.theatreId = theatreId;
		this.seats = seats;
		this.totalPrice = totalPrice;
		this.numberOfTickets = numberOfTickets;
		this.bookedDate = bookedDate;
		this.showTime = showTime;
		this.paymentMethod = paymentMethod;
		this.bookingType = bookingType;
	}
	
	

	
	
    }
