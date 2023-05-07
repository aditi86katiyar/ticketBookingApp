package com.sapient.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReserveSeatCommand {


	
	String bookingId;

	@JsonProperty("theatreId")
	String theatreId;
	
    @JsonProperty("seats")
	Map<String, List<String>> seats;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public Map<String, List<String>> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, List<String>> seats) {
		this.seats = seats;
	}

	public ReserveSeatCommand(String bookingId, String theatreId, Map<String, List<String>> seats) {
		super();
		this.bookingId = bookingId;
		this.theatreId = theatreId;
		this.seats = seats;
	}
	
	public ReserveSeatCommand() {
		
	}
    
    

}
