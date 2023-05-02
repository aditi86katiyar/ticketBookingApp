package com.sapient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

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
			List<MovieSeat> movieSeatsList=new ArrayList<>();

			for(Seat seat:_theatre.getSeats()) {
				for(int i=seat.getFromSeat();i<seat.getToSeat();i++) {
					MovieSeat movieSeat=new  MovieSeat(_theatre.getId(),new StringBuilder().append(seat.getRowType()).append(String.format("%02d", i)).toString(), true,seat.getSeatType());
					movieSeat.setSeatType(seat.getSeatType());
					movieSeatsList.add(movieSeat);
			
				}

				}
			movieSeatsRepository.saveAll(movieSeatsList);

		} catch(DuplicateKeyException e) {
			throw new TheatreAlreadyExists(e);
		}catch(Exception e) {
			throw new Exception(e);
		}
		return theatre;
	}  
	
	
	public List<MovieSeat> checkSeatsAvailable(@RequestBody BookingRequestVo bookingRequestVo) {
		 List<MovieSeat> movieSeat = null ;
		// Create a list of MovieSeat objects
		List<MovieSeat> movieSeatsFetched = new ArrayList<>();

		// Iterate over the seat numbers in the bookingRequestVo and add matching MovieSeat objects to the list
		for (Entry<String, List<String>> seatEntry : bookingRequestVo.getSeatNumbers().entrySet()) {
			
		    String seatType = seatEntry.getKey();
		    List<String> seatNumbers = seatEntry.getValue();
		         movieSeat = movieSeatsRepository.findByTheatreIdAndSeatTypeAndSeatNumberIn(bookingRequestVo.getTheatreId(),"SILVER",seatNumbers);
		        movieSeatsFetched.addAll(movieSeat);
		    }
		return movieSeat;
		
		}


	public List<MovieSeat> checkSeatsAvailable(String theatreId, String seatType, List<String>seatNumbers) {
		 List<MovieSeat> movieSeat = null ;
			List<MovieSeat> movieSeatsFetched = new ArrayList<>();

	         movieSeat = movieSeatsRepository.findByTheatreIdAndSeatTypeAndSeatNumberIn(theatreId,seatType,seatNumbers);
	         movieSeatsFetched.addAll(movieSeat);
			return movieSeat;
}
	
	}
	
	


