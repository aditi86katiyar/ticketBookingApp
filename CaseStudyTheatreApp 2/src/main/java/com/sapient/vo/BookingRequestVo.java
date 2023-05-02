package com.sapient.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookingRequestVo {
	
	String movieName;
	String theatreName;
	String seatNumber;
	String seatType;
	Date movieTiming;
	String location;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
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
	public Date getMovieTiming() {
		return movieTiming;
	}
	public void setMovieTiming(Date movieTiming) {
		this.movieTiming = movieTiming;
	}
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public static void main(String args) throws JsonProcessingException {
		
		List<Date> movieTimings=new ArrayList<>();
		movieTimings.add(new Date());
		String dateString = "2023-04-016T14:30:00.000-0700";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		BookingRequestVo bookingRequestVo=new BookingRequestVo();
		
		bookingRequestVo.setMovieName("Top Gun 31");
		bookingRequestVo.setTheatreName("Galaxy");
		bookingRequestVo.setMovieTiming(date);
		bookingRequestVo.setSeatNumber("6");
		bookingRequestVo.setSeatType(SEAT_TYPES.SILVER.toString());
		
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.writeValueAsString(bookingRequestVo);

	}

}
