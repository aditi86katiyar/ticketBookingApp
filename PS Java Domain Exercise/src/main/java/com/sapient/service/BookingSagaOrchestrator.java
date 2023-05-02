package com.sapient.service;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.sapient.repository.MovieSeatsRepository;
import com.sapient.vo.ReserveSeatCommand;

public class BookingSagaOrchestrator {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @Autowired
    private MovieSeatsRepository movieSeatsRepository;

    @KafkaListener(topics = "seatReservedTopic")
    public void handleTicketReservedEvent(ReserveSeatCommand reserveSeatCommand) {
        Long bookingId = reserveSeatCommand.getBookingId();
        for(Entry<String,List<String>> seat:reserveSeatCommand.getSeats().entrySet()) {
        	
        	movieSeatsRepository.updateSeatTypeAndStatus(reserveSeatCommand.getTheatreId(), seat.getKey(), seat.getValue());
        }
        
        // Send an acknowledgement to the ticket service
        kafkaTemplate.send("ticketReservationAcknowledgedTopic", bookingId);
    }

}

