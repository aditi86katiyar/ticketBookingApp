package com.sapient.vo;

import java.util.Date;

public class MovieSeat {
	
	
	int seatNumber;
	
	SEAT_TYPES seatType;
	
	boolean isAvailable;

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SEAT_TYPES getSeatType() {
		return seatType;
	}

	public void setSeatType(SEAT_TYPES seatType) {
		this.seatType = seatType;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public MovieSeat(int seatNumber, SEAT_TYPES seatType, boolean isAvailable) {
		super();
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.isAvailable = isAvailable;
	}

		
	 

}
