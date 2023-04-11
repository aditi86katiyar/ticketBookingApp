package com.sapient.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="theatre")
public class Theatre {
	
	@Id
	String id;
	
	String theatreName;
	
	String screenNumber;
	
	Movie movie;
	
	List<Date> movieTiming;
	
	Address address;
	
	List<Seat> seats=new ArrayList<>();
	
	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Date> getMovieTiming() {
		return movieTiming;
	}

	public void setMovieTiming(List<Date> movieTiming) {
		this.movieTiming = movieTiming;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Theatre(String theatreName, String screenNumber, Movie movie, List<Date> movieTiming, Address address,
			List<Seat> seats) {
		super();
		this.theatreName = theatreName;
		this.screenNumber = screenNumber;
		this.movie = movie;
		this.movieTiming = movieTiming;
		this.address = address;
		this.seats = seats;
	}		
	
	
	
}
