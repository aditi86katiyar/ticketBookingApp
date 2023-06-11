package com.sapient.vo;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	
	public static void main(String [] args) throws JsonProcessingException {
		
		String dateString = "2023-06-01T10:30:00-04:00[America/New_York]";
		ZonedDateTime dateTime = ZonedDateTime.parse(dateString);

		
		List<ShowTiming> showtimings=new ArrayList<>();
		showtimings.add(new ShowTiming(dateTime, "123"));
		List<Seat> seats=new ArrayList<>();
		Seat seat=new Seat();
		seat.setFromSeat(0);
		seat.setFromSeat(500);
		seat.setSeatType("SILVER");
		seat.setRowType("A");
		seats.add(seat);
		Theatre theatre=new Theatre(null, "Test", "1", new Movie("tOP GIB", MOVIE_STATUS.MOVIE_AVAILABLE, 5), null, new Address("o-703 haware glory", "Sector-20", "Kharghar", "Navi Mumbai", "Navi Mumbai", "410210"), seats);
		ObjectMapper mapper=new ObjectMapper();
		String theatreStr=mapper.writeValueAsString(theatre);
		System.out.println(theatreStr);
	}

		
	
	
	
}
