package com.sapient.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.sapient.vo.Seat;
import com.sapient.vo.Theatre;
import com.spaient.exception.TheatreAlreadyExists;

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
			Theatre _theatre = theatreRepository
					.save(theatre);
			List<MovieSeat> movieSeats=new ArrayList<>();
			for(Seat seat:_theatre.getSeats()) {
				for(int i=seat.getFromSeat();i<seat.getToSeat();i++) {
					MovieSeat movieSeat=new MovieSeat(i,seat.getSeatType(),true);
					movieSeat.setTheatreId(_theatre.getId());
					movieSeats.add(movieSeat);
					}
				}
			movieSeatsRepository.saveAll(movieSeats);
		} catch(DuplicateKeyException e) {
			throw new TheatreAlreadyExists(e);
		}catch(Exception e) {
			throw new Exception(e);
		}
		return theatre;
	}  
	
	
	public MovieSeat getSeatsByTheaterId(@RequestBody BookingRequestVo bookingRequestVo) {
		List<Date> movieTimings=new ArrayList<>();
		movieTimings.add(bookingRequestVo.getMovieTiming());
		Theatre _theatre=theatreRepository.findByTheatreNameMovieNameCity(bookingRequestVo.getTheatreName(),bookingRequestVo.getMovieName(),bookingRequestVo.getLocation());
		   if (_theatre == null) {
System.out.println("returns null");		   }
		   MovieSeat seats = movieSeatsRepository.findByTheatreIdAndSeat(_theatre.getId(),Integer.parseInt(bookingRequestVo.getSeatNumber()),bookingRequestVo.getSeatType());
		   return seats;
		}
	
	
}

