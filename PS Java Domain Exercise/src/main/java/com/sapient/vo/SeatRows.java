package com.sapient.vo;

import java.util.List;

public class SeatRows {
	
	List<String>rownumber;
	Integer seatNumber;
	public List<String> getRownumber() {
		return rownumber;
	}
	public void setRownumber(List<String> rownumber) {
		this.rownumber = rownumber;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public SeatRows(List<String> rownumber, Integer seatNumber) {
		super();
		this.rownumber = rownumber;
		this.seatNumber = seatNumber;
	}
	
	
	
	
	
	

}
