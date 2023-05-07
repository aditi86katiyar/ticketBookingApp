package com.sapient.controller;

import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.service.KafkaService;
import com.sapient.service.ReserveSeatCommand;
import com.sapient.service.TheatreService;
import com.sapient.vo.Booking;
import com.sapient.vo.BookingRequestVo;

@RestController
@RequestMapping("/booking/v1")
public class BookingController {

	@Autowired
	KafkaService kafkaService;
	
	@Autowired
	TheatreService theatreService;

  

    @PostMapping("/produce")
    public ResponseEntity<String> produceMessage(@RequestBody Booking booking) {
    	
    	BookingRequestVo bookingRequestVo=new BookingRequestVo();
    	bookingRequestVo.setTheatreId(booking.getTheatreId());
    	for(Entry<String, List<String>> seat:booking.getSeats().entrySet()) {
        	System.out.println(seat.getKey());
        	System.out.println(seat.getValue().toString());

    		bookingRequestVo.setSeatType(seat.getKey());
    		bookingRequestVo.setSeats(String.join(",",seat.getValue()));

    	}
    	booking.setId(UUID.randomUUID().toString());

    	ReserveSeatCommand seatCommand=new ReserveSeatCommand(booking.getId(), booking.getTheatreId(), booking.getSeats());
    	
       		System.out.println("Data pushed to kafka");
    		kafkaService.produce("seatReservedTopic",seatCommand);
			return new ResponseEntity("Booking Process Started", HttpStatus.OK);
    }
}

