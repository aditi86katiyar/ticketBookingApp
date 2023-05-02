package com.sapient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.service.KafkaService;
import com.sapient.service.TheatreService;
import com.sapient.vo.Booking;
import com.sapient.vo.BookingRequestVo;
import com.sapient.vo.MovieSeat;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/booking/v1")
public class BookingController {

	@Autowired
	KafkaService kafkaService;
	
	@Autowired
	TheatreService theatreService;

  

    @PostMapping("/produce")
    public ResponseEntity<List<MovieSeat>> produceMessage(@RequestBody Booking booking) {
    	
    	BookingRequestVo bookingRequestVo=new BookingRequestVo();
    	bookingRequestVo.setTheatreId(booking.getTheatreId());
    	for(Entry<String, List<String>> seat:booking.getSeats().entrySet()) {
        	System.out.println(seat.getKey());
        	System.out.println(seat.getValue().toString());

    		bookingRequestVo.setSeatType(seat.getKey());
    		bookingRequestVo.setSeats(String.join(",",seat.getValue()));

    	}
    	List<MovieSeat> movieSeats=theatreService.getSeatsAvailable(bookingRequestVo);
    	boolean bookSeats=false;
    	for(MovieSeat movieSeat:movieSeats) {
    		if(movieSeat.isAvailable()) {
    			bookSeats=true;
    		}else {
    			bookSeats=false;

    		}
    	}
    	if(bookSeats) {
    		System.out.println("Data pushed to kafka");
    		kafkaService.produce("booking-topic",booking);
			return new ResponseEntity<List<MovieSeat>>(movieSeats, HttpStatus.OK);

    	} else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    	}
    }
}

