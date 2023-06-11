package com.sapient.vo;

import java.time.ZonedDateTime;

public class TheatreRequestVo {
	
	String movie;
	
	ZonedDateTime showTime;
	
	
	String city;


	public String getMovie() {
		return movie;
	}


	public void setMovie(String movie) {
		this.movie = movie;
	}


	public ZonedDateTime getShowTime() {
		return showTime;
	}


	public void setShowTime(ZonedDateTime showTime) {
		this.showTime = showTime;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
		
}
