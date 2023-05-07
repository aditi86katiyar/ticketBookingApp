package com.sapient.vo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieSeats")
public class MovieSeats {
	
	@Id
	private String id;
	
	String theatreId;
	List<MovieSeat> seats;
	

		


	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	

	public List<MovieSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<MovieSeat> seats) {
		this.seats = seats;
	}

	public MovieSeats() {
		
	}

	
	
	
}
