package com.sapient.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TheatreConsumer {
	
	    @KafkaListener(topics = "${kafka.topic.name}",groupId = "${kafka.consumer.group-id}")
	    public void consume(String message) {
	        // Process the message
	        System.out.println("Received message: " + message);
	        ObjectMapper objectMapper=new ObjectMapper();
	        try {
				//MovieSeats movieSeats = objectMapper.readValue(message, MovieSeats.class);
				//seatRepository.save(movieSeats);
				

				System.out.println("Name" +message);
} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	

}
