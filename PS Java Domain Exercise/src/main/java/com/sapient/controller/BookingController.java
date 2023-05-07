package com.sapient.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.service.TheatreDetailsService;
import com.sapient.vo.MovieSeats;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/booking/v1/")
public class BookingController {
	
	@Autowired
	TheatreDetailsService theatreDetailsService;
	
	@GetMapping("checkSeats/theatreId/{theatreId}/seatType/{seatType}/seatNumbers/{seatNumbers}")
	public ResponseEntity<Optional<MovieSeats>> getSeatsAvailability(@PathVariable("theatreId") String theatreId,@PathVariable("seatType") String seatType,@PathVariable("seatNumbers") String seatNumbers ) {
		try {
		    List<String> seatNumbersList = Arrays.asList(seatNumbers.split(","));
			Optional<MovieSeats> _movieSeats = theatreDetailsService.checkSeatsAvailable(theatreId,seatType,seatNumbersList);
			return new ResponseEntity<Optional<MovieSeats>>(_movieSeats, HttpStatus.OK);
		} catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	}
