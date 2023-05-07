package com.sapient.vo;

public class MovieSeat {
	
	
	private String id;
	
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
	




	public MovieSeat(String seatNumber, boolean isAvailable, String seatType) {
		super();
		this.seatNumber = seatNumber;
		this.isAvailable = isAvailable;
		this.seatType = seatType;
	}

	public MovieSeat() {
		
	}

	
	
	
}
