package com.sapient.vo;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="booking")
public class Booking {
	
	@org.springframework.data.annotation.Id
	Long bookingId;
	
	User user;
	
	MovieSeats movieSeats;

    int amount;
    
    int numberOfTickets;
	
	PAYMENT_STATUS paymentStatus;
	
	Date bookedDate;
	
    private LocalDateTime showTime;
    
    private String paymentMethod;
    
    private double totalCost;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MovieSeats getMovieSeats() {
		return movieSeats;
	}

	public void setMovieSeats(MovieSeats movieSeats) {
		this.movieSeats = movieSeats;
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

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

		
}
