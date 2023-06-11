package com.sapient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.sapient.repository.MovieSeatsRepository;
import com.sapient.repository.ShowTimingRepository;
import com.sapient.repository.TheatreRepository;
import com.sapient.vo.BookingRequestVo;
import com.sapient.vo.MovieSeat;
import com.sapient.vo.MovieSeats;
import com.sapient.vo.Seat;
import com.sapient.vo.Theatre;
import com.spaient.exception.TheatreAlreadyExists;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import reactor.core.publisher.Mono;

@Service
public class TheatreDetailsService {
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	MovieSeatsRepository movieSeatsRepository;
	
	@Autowired
	ShowTimingRepository showTimingRepository;
	
	@Transactional
	public Theatre addMovieTheatre(Theatre theatre) throws Exception {
		try {
			Mono<Theatre> _theatre = theatreRepository
					.save(theatre);
			MovieSeats movieSeats=new MovieSeats();
			List<MovieSeat> movieSeatsList=new ArrayList<>();
			movieSeats.setTheatreId(_theatre.block().getId());
			for(Seat seat:_theatre.block().getSeats()) {
				for(int i=seat.getFromSeat();i<seat.getToSeat();i++) {
					MovieSeat movieSeat=new  MovieSeat(new StringBuilder().append(seat.getRowType()).append(String.format("%02d", i)).toString(), true,seat.getSeatType());
					movieSeat.setSeatType(seat.getSeatType());
					movieSeatsList.add(movieSeat);
			
				}

				}
			movieSeats.setSeats(movieSeatsList);
			movieSeatsRepository.save(movieSeats);

		} catch(DuplicateKeyException e) {
			throw new TheatreAlreadyExists(e);
		}catch(Exception e) {
			throw new Exception(e);
		}
		return theatre;
	}  
	
	
	public MovieSeats checkSeatsAvailable(@RequestBody BookingRequestVo bookingRequestVo) {
		 MovieSeats movieSeat = null ;
		 
		 // Iterate over the seat numbers in the bookingRequestVo and add matching MovieSeat objects to the list
		for (Entry<String, List<String>> seatEntry : bookingRequestVo.getSeatNumbers().entrySet()) {
			
		    List<String> seatNumbers = seatEntry.getValue();
		         movieSeat = movieSeatsRepository.findByTheatreId(bookingRequestVo.getTheatreId());
		         List<MovieSeat> updatedMovieSeats=movieSeat.getSeats().stream().filter(seat -> seatNumbers.contains(seat.getSeatNumber())).peek(seat -> seat.setAvailable(false)).collect(Collectors.toList());
		         movieSeat.getSeats().stream().filter(seat -> "A03".equals(seat.getSeatNumber())).forEach(seat -> System.out.println("Print seat availability" +seat.getSeatNumber() +seat.isAvailable()));
		         System.out.println("Print seat availability");
		         movieSeat.setSeats(updatedMovieSeats);
		         movieSeatsRepository.save(movieSeat);		   
		         }
		return movieSeat;
		
		}


	public Mono<Optional<MovieSeats>> checkSeatsAvailable(String theatreId, String seatType, List<String> seatNumbers) {
	    return movieSeatsRepository.findById(theatreId)
	            .map(Optional::ofNullable);
	}

	
	}
	
	


