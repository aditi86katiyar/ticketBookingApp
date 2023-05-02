package com.sapient.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieSeats")
public class MovieSeat {
	
	@Id
	private String id;
	
	String theatreId;
	String seatNumber;
	boolean isAvailable;
	String seatType;
	

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	
	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	


	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public MovieSeat(String theatreId, String seatNumber, boolean isAvailable, String seatType) {
		super();
		this.theatreId = theatreId;
		this.seatNumber = seatNumber;
		this.isAvailable = isAvailable;
		this.seatType = seatType;
	}

	

	
	
	
}
