package com.sapient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.vo.BookingRequestVo;
import com.sapient.vo.MovieSeat;

@Service
public class TheatreService {

    
    public  List<MovieSeat> getSeatsAvailable(BookingRequestVo bookingRequestVo) {
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	HttpEntity<BookingRequestVo> entity = null ;
    	List<MovieSeat> movieSeats = new ArrayList<>();
    	RestTemplate restTemplate = new RestTemplate();
    		String seatType=bookingRequestVo.getSeatType();
    		System.out.println(seatType);
    		String seatNumbers = String.join(",", bookingRequestVo.getSeats());
    		System.out.println(seatNumbers);

    	String url = "http://35.192.127.181:8081/booking/v1/checkSeats/theatreId/"+bookingRequestVo.getTheatreId()+"/seatType/"+seatType+"/seatNumbers/"+seatNumbers;
    	System.out.println("URL" +url);
    	ResponseEntity<List<MovieSeat>> responseEntity = restTemplate.exchange(
    	    url,
    	    HttpMethod.GET,
    	    entity,
    	    new ParameterizedTypeReference<List<MovieSeat>>() {}
    	);
    	
    	movieSeats = responseEntity.getBody();
    	
		return movieSeats;
    }
    
  
}
    
