package com.sapient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.repository.ShowTimingRepository;
import com.sapient.vo.ShowTimeRequestVo;
import com.sapient.vo.ShowTiming;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/showtimings/v1")
public class ShowTimingController {
	
	@Autowired
	ShowTimingRepository showTimingRepository;
	
	@GetMapping("/showtiming/")
	public ResponseEntity<List<ShowTiming>> getMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
			List<ShowTiming> _showTimings=showTimingRepository.findByTheatreId(showTimeRequestVo.getTheatreId());
			return new ResponseEntity<List<ShowTiming>>(_showTimings, HttpStatus.OK);
		}
	
	@PostMapping("/showtiming/")
	public ResponseEntity<List<ShowTiming>> addMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
		List<ShowTiming> showTimings=new ArrayList<>();
		showTimeRequestVo.getShowTiming().stream().forEach(showtime -> showTimings.add(new ShowTiming(showtime, showTimeRequestVo.getTheatreId())));
		List<ShowTiming> _showTimings=showTimingRepository.saveAll(showTimings);
		return new ResponseEntity<List<ShowTiming>>(_showTimings, HttpStatus.CREATED);
		}
	
	@PutMapping("/showtiming/")
	public ResponseEntity<List<ShowTiming>> updateMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
		List<ShowTiming> showtimedb=showTimingRepository.findByTheatreId(showTimeRequestVo.getTheatreId());
		showTimeRequestVo.getShowTiming().stream().forEach(showtime -> showtimedb.add(new ShowTiming(showtime, showTimeRequestVo.getTheatreId())));
		List<ShowTiming> _showTimings=showTimingRepository.saveAll(showtimedb);
		return new ResponseEntity<List<ShowTiming>>(_showTimings, HttpStatus.OK);
		}
	
	@DeleteMapping("/showtiming/")
	public ResponseEntity<String> deleteMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
		showTimeRequestVo.getShowTiming().stream().forEach(showtime -> showTimingRepository.deleteByShowTimeAndTheatreId(showtime, showTimeRequestVo.getTheatreId()));
		return new ResponseEntity<String>("Shows are deleted successfully", HttpStatus.NO_CONTENT);
		}
	
	

}
