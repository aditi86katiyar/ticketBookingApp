package com.sapient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.service.TheatreDetailsService;
import com.sapient.vo.BookingRequestVo;
import com.sapient.vo.MovieSeat;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/booking/v1")
public class BookingController {
	
	@Autowired
	TheatreDetailsService theatreDetailsService;
	
	@GetMapping("bookings/")
	public ResponseEntity<MovieSeat> addMovieTheatre(@RequestBody BookingRequestVo bookingRequestVo) {
		try {
			MovieSeat _movieSeats = theatreDetailsService.getSeatsByTheaterId(bookingRequestVo);
			return new ResponseEntity<MovieSeat>(_movieSeats, HttpStatus.OK);
		} catch (Exception e) {
            e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
