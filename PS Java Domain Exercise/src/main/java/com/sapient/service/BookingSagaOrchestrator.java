package com.sapient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.sapient.repository.MovieSeatsRepository;
import com.sapient.vo.MovieSeat;
import com.sapient.vo.MovieSeats;

@Component
public class BookingSagaOrchestrator {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @Autowired
    private MovieSeatsRepository movieSeatsRepository;

    @KafkaListener(topics = "seatReservedTopic",groupId = "seats-consumer")
    public void handleTicketReservedEvent(ReserveSeatCommand reserveSeatCommand) {
        String bookingId = reserveSeatCommand.getBookingId();

        for (Entry<String, List<String>> seat : reserveSeatCommand.getSeats().entrySet()) {
            String theatreId = reserveSeatCommand.getTheatreId();
            List<String> seatNumbers = seat.getValue();

            MovieSeats movieSeats = movieSeatsRepository.findByTheatreId(theatreId);
            List<MovieSeat> updatedMovieSeats = new ArrayList<>();

            for (MovieSeat movieSeat : movieSeats.getSeats()) {
                if (seatNumbers.contains(movieSeat.getSeatNumber())) {
                    movieSeat.setAvailable(false);
                }
                updatedMovieSeats.add(movieSeat);
            }

            movieSeats.setSeats(updatedMovieSeats);
            movieSeatsRepository.save(movieSeats);
        }

        // Send an acknowledgement to the ticket service
        kafkaTemplate.send("initiatePaymentTopic", bookingId);
    }








    BookingSagaOrchestrator(){
    	
    }

}

