package com.sapient.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.repository.MovieSeatsRepository;
import com.sapient.repository.TheatreRepository;
import com.sapient.vo.MovieSeat;
import com.sapient.vo.MovieSeats;
import com.sapient.vo.SEAT_TYPES;
import com.sapient.vo.Seat;
import com.sapient.vo.Theatre;
import com.spaient.exception.TheatreAlreadyExists;

@Service
public class TheatreDetailsService {
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	MovieSeatsRepository movieSeatsRepository;
	
	@Transactional
	public Theatre addMovieTheatre(Theatre theatre) throws Exception {
		try {
			Theatre _theatre = theatreRepository
					.save(theatre);
			
			for(Date movieTiming:_theatre.getMovieTiming()) {
			
			List<MovieSeat> movieSeats=new ArrayList();
			
			for(Seat seat:_theatre.getSeats()) {
				for(int i=seat.getFromSeat();i<seat.getToSeat();i++) {
					movieSeats.add(new MovieSeat(i, SEAT_TYPES.valueOf(seat.getSeatType()),true));
					}
				}
			
			MovieSeats movieSeatObj=new MovieSeats();
			movieSeatObj.setMovieName(_theatre.getTheatreName());
			movieSeatObj.setMovieTiming(movieTiming);
			movieSeatObj.setMovieSeats(movieSeats);
			movieSeatObj.setTheatreName(_theatre.getTheatreName());
			movieSeatObj.setTheatreAddress(_theatre.getAddress());
			ObjectMapper mapper=new ObjectMapper();
			
			System.out.println(mapper.writeValueAsString(movieSeatObj));
			movieSeatsRepository.save(movieSeatObj);
			}
		} catch(DuplicateKeyException e) {
			throw new TheatreAlreadyExists(e);
		}catch(Exception e) {
			throw new Exception(e);
		}
		return theatre;
	}  
	
	public MovieSeats findMovieSeats(String movieName,String theatreName, String location, Date showTimings,String seatNumber, String seatType) {
		return movieSeatsRepository.findSeatsByMovieName(theatreName,movieName, location, showTimings,seatNumber,seatType);
	}
}

