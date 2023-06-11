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
import com.sapient.repository.TheatreRepository;
import com.sapient.util.DateUtil;
import com.sapient.vo.ShowTimeRequestVo;
import com.sapient.vo.ShowTiming;
import com.sapient.vo.Theatre;
import com.sapient.vo.TheatreRequestVo;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/showtimings/v1")
public class ShowTimingController {
	
	@Autowired
	ShowTimingRepository showTimingRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@GetMapping("/showtiming/")
	public ResponseEntity<List<ShowTiming>> getMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
			List<ShowTiming> _showTimings=showTimingRepository.findByTheatreId(showTimeRequestVo.getTheatreId());
			return new ResponseEntity<List<ShowTiming>>(_showTimings, HttpStatus.OK);
		}
	
	@PostMapping("/showtiming/")
	public ResponseEntity<Flux<ShowTiming>> addMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
		List<ShowTiming> showTimings=new ArrayList<>();
		showTimeRequestVo.getShowTiming().stream().forEach(showtime -> showTimings.add(new ShowTiming(DateUtil.dateConverter(showtime), showTimeRequestVo.getTheatreId())));
		Flux<ShowTiming> _showTimings=showTimingRepository.saveAll(showTimings);
		return new ResponseEntity<Flux<ShowTiming>>(_showTimings, HttpStatus.CREATED);
		}
	
	@PutMapping("/showtiming/")
	public ResponseEntity<Flux<ShowTiming>> updateMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
		List<ShowTiming> showtimedb=showTimingRepository.findByTheatreId(showTimeRequestVo.getTheatreId());
		showTimeRequestVo.getShowTiming().stream().forEach(showtime -> showtimedb.add(new ShowTiming(DateUtil.dateConverter(showtime), showTimeRequestVo.getTheatreId())));
		Flux<ShowTiming> _showTimings=showTimingRepository.saveAll(showtimedb);
		return new ResponseEntity<Flux<ShowTiming>>(_showTimings, HttpStatus.OK);
		}
	
	@DeleteMapping("/showtiming/")
	public ResponseEntity<String> deleteMovieTimings(@RequestBody ShowTimeRequestVo showTimeRequestVo)  {
		showTimeRequestVo.getShowTiming().stream().forEach(showtime -> showTimingRepository.deleteByShowTimeAndTheatreId(DateUtil.dateConverter(showtime), showTimeRequestVo.getTheatreId()));
		return new ResponseEntity<String>("Shows are deleted successfully", HttpStatus.NO_CONTENT);
		}
	
	@GetMapping("/searchtheatre")
	public List<Theatre> getAllTheatresWithShowTimings(@RequestBody TheatreRequestVo theatreRequestVo) {
		List<Theatre> theatreWithShowTimings=new ArrayList<>();
		List<Theatre> theatres = theatreRepository.findByMovieNameCity(theatreRequestVo.getMovie(),theatreRequestVo.getCity());
        for(Theatre theatre:theatres) {
        	ShowTiming showTime=showTimingRepository.findByTheatreIdAndShowTime(theatreRequestVo.getShowTime(),theatre.getId());
        	if(showTime!=null) {
        		System.out.println(showTime.getShowTiming());
        		ArrayList<ShowTiming> showtimes=new ArrayList<>();
        		showtimes.add(showTime);
        		theatre.setShowTimings(showtimes);
        		theatreWithShowTimings.add(theatre);
        	}else {
        		System.out.println("returns null");

        	}
        }
       
        return theatreWithShowTimings;
    }
	
	

}
