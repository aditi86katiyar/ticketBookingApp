package com.sapient.vo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Address {
	
	long address_id;
	String addressLine1;
	
	String addressLine2;
	
	String landmark;

	String city;

	String state;
	
	String pinCode;

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Address(String addressLine1, String addressLine2, String landmark, String city, String state,
			String pinCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public Address() {
		
	}
	
	
	public static void main(String args[]) throws JsonProcessingException {
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
		bookingRequestVo.setLocation("Navi Mumbai");

		bookingRequestVo.setSeatType("SILVER");
		
		ObjectMapper objectMapper=new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(bookingRequestVo));	    
	}


}
