package com.sapient.vo;

import java.util.ArrayList;
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
	
	List<ShowTiming> showTimings;
	
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

	

	public List<ShowTiming> getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(List<ShowTiming> showTimings) {
		this.showTimings = showTimings;
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
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Theatre(String id, String theatreName, String screenNumber, Movie movie, List<ShowTiming> showTimings,
			Address address, List<Seat> seats) {
		super();
		this.id = id;
		this.theatreName = theatreName;
		this.screenNumber = screenNumber;
		this.movie = movie;
		this.showTimings = showTimings;
		this.address = address;
		this.seats = seats;
	}

		
	
	
	
}
