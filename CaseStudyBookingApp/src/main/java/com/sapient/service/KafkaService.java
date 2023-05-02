package com.sapient.service;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.repository.BookingRepository;
import com.sapient.vo.Booking;

@Service
public class KafkaService {

    @Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
    
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    public KafkaService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> message) throws IOException {
    	        	ObjectMapper objectMapper = new ObjectMapper();
    	        	JsonNode booking = null;

    	        	try {
    	        	    booking = objectMapper.readTree(message.value().getBytes());
    	        	    int numberOfTickets = booking.get("numberOfTickets").asInt();
    	        	    double totalPrice = booking.get("totalPrice").asDouble();
    	        	    

    	        	    String userId = booking.get("userId").asText();
    	        	    String theatreId = booking.get("theatreId").asText();
    	        	    String seats = booking.get("seats").asText();

    	        	    Booking booking2=new Booking(userId, theatreId, null, totalPrice, numberOfTickets, null, null, null, null);
    	        	    
    	        	    bookingRepository.save(booking2);
    	        	    kafkaTemplate.send("initiatePaymentTopic", new InitiatePaymentCommand(booking2.getId(), totalPrice));
    	                kafkaTemplate.send("seatReservedTopic", new ReserveSeatCommand(booking2.getId(),theatreId,seats));
    	              

    	                System.out.println("Received message: " + numberOfTickets);

      	        	} catch (JsonProcessingException e) {
    	        	    e.printStackTrace();
    	        	}

        
    }

    public void produce(String topic, Booking message) {
        	ObjectMapper objectMapper=new ObjectMapper();
            try {
            	String booking=objectMapper.writeValueAsString(message);
				kafkaTemplate.send(topic, objectMapper.writeValueAsString(message));
				System.out.println("Message pushed to kafka" +booking );
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
 
}
