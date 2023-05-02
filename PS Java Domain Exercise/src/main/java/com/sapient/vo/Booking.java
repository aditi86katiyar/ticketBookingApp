package com.sapient.vo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Booking {
	
	Long bookingId;
	
   Theatre theatre;

    int amount;
    
    int numberOfTickets;
	
	PAYMENT_STATUS paymentStatus;
	
	Date bookedDate;
	
	Time movieTiming;
	
	List<Seat> seats=new ArrayList<>();

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	
	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public PAYMENT_STATUS getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PAYMENT_STATUS paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Time getMovieTiming() {
		return movieTiming;
	}

	public void setMovieTiming(Time movieTiming) {
		this.movieTiming = movieTiming;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
