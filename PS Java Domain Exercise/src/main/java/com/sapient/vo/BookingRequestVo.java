package com.sapient.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookingRequestVo {
	
	String theatreId;
	Map<String,List<String>> seatNumbers=new HashMap<>();
	
	public String getTheatreId() {
		return theatreId;
	}
	public BookingRequestVo(String theatreId, Map<String, List<String>> seatNumbers) {
		super();
		this.theatreId = theatreId;
		this.seatNumbers = seatNumbers;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public Map<String, List<String>> getSeatNumbers() {
		return seatNumbers;
	}
	public void setSeatNumbers(Map<String, List<String>> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	
	

	
	
	}
