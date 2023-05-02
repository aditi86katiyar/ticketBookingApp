package com.sapient.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieSeats")
public class MovieSeat {
	
	@Id
	private String id;
	
	int seatNumber;
	
	String seatType;
	
	String theatreId;
	
	boolean isAvailable;

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	
	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
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

	public MovieSeat(int seatNumber, String seatType, boolean isAvailable) {
		super();
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.isAvailable = isAvailable;
	}

	
	

		
	 

}
