package com.sapient.vo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="movieSeats")
public class MovieSeats {
	
	Date movieTiming;
	String movieName;
	String theatreName;
	Address theatreAddress;
	
	List<MovieSeat> movieSeats;

	public List<MovieSeat> getMovieSeats() {
		return movieSeats;
	}

	public void setMovieSeats(List<MovieSeat> movieSeats) {
		this.movieSeats = movieSeats;
	}


	public Date getMovieTiming() {
		return movieTiming;
	}

	public void setMovieTiming(Date movieTiming) {
		this.movieTiming = movieTiming;
	}

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

	public Address getTheatreAddress() {
		return theatreAddress;
	}

	public void setTheatreAddress(Address theatreAddress) {
		this.theatreAddress = theatreAddress;
	}
	
	
	
	

}
