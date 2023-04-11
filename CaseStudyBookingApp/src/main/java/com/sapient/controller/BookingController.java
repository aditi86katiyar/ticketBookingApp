package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.repository.BookingRepository;
import com.sapient.vo.Booking;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/booking/v1")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@PostMapping("/booking")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking ) {
		try {
			Booking _theatre = bookingRepository
					.save(booking);
			return new ResponseEntity<>(_theatre, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/booking")
	public ResponseEntity<Booking> cancelBooking(@RequestBody Booking booking) {
		try {
			bookingRepository.delete(booking);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
