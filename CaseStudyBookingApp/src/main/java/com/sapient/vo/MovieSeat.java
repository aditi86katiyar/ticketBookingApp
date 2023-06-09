package com.sapient.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "movieSeats")
public class MovieSeat {
	
	@Id
	private String id;
	
	String theatreId;
	String seatNumber;
	boolean available;
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
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public MovieSeat(String theatreId, String seatNumber, boolean available, String seatType) {
		super();
		this.theatreId = theatreId;
		this.seatNumber = seatNumber;
		this.available = available;
		this.seatType = seatType;
	}

	 @JsonCreator
	    public MovieSeat(@JsonProperty("theatreId") String theatreId,
	    				 @JsonProperty("seatNumber") String seatNumber,
	                     @JsonProperty("seatType") String seatType,
	                     @JsonProperty("available") boolean available) {
	        this.theatreId = theatreId;
	        this.seatNumber = seatNumber;
	        this.seatType = seatType;
	        this.available = available;	
	 }
	
	
	
}
