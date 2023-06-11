package com.sapient.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.repository.TheatreRepository;
import com.sapient.service.TheatreDetailsService;
import com.sapient.vo.Theatre;
import com.spaient.exception.TheatreAlreadyExists;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/onboarding/v1")
public class TheatreOnboardingController {
	
	@Autowired
	TheatreDetailsService theatreDetailsService;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	
	
	@GetMapping("/theatre")
	public ResponseEntity<Flux<Theatre>> getMovieTheatre(@RequestBody Theatre theatre)  {
			Flux<Theatre> _theatre=theatreRepository.findByTheatreNameMovieNameCity(theatre.getTheatreName(),theatre.getMovie().getMovieName(),theatre.getAddress().getCity());
			return new ResponseEntity<>(_theatre, HttpStatus.OK);
		}
	
	@PutMapping("/theatre")
	public ResponseEntity<Theatre> updateShowTimings (@RequestBody Theatre theatre)  {
		
			
			Theatre _theatre=theatreRepository.findByTheatreName(theatre.getTheatreName(),theatre.getMovie());
			_theatre.setShowTimings(theatre.getShowTimings());
			theatreRepository.save(_theatre);
			return new ResponseEntity<>(_theatre, HttpStatus.OK);
		}
		
	
	@PostMapping("/theatre")
	public ResponseEntity<Theatre> addMovieTheatre(@RequestBody Theatre theatre) throws Exception {
		try {
			Theatre _theatre = theatreDetailsService.addMovieTheatre(theatre);
			return new ResponseEntity<>(_theatre, HttpStatus.CREATED);
		} catch(DuplicateKeyException e) {
			throw new TheatreAlreadyExists(e);
		}catch(Exception e) {
			throw new Exception(e);
		}
	} 
	
	
	     
	@DeleteMapping("/theatre/{dateTime1}")
	public ResponseEntity<Theatre> deleteTutorial(@PathVariable("showTime")Date showTime) {
	   	try {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	catch (Exception e) {
        e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

	
	


