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
    	boolean bookingSeatsAvailable=false;
    	List<String> seatNumbers=new ArrayList<>();
        for (Entry<String, List<String>> seat : reserveSeatCommand.getSeats().entrySet()) {
            String theatreId = reserveSeatCommand.getTheatreId();
            seatNumbers = seat.getValue();
            System.out.println("seats"+seat.getValue());
        }
            MovieSeats movieSeats = movieSeatsRepository.findByTheatreId(reserveSeatCommand.getTheatreId());
            List<MovieSeat> updatedMovieSeats = new ArrayList<>();

            for (MovieSeat movieSeat : movieSeats.getSeats()) {
                System.out.println("movieSeat inside"+movieSeat);

                if (seatNumbers.contains(movieSeat.getSeatNumber())) {
                    movieSeat.setAvailable(false);
                	bookingSeatsAvailable=true;
                    System.out.println("seats inside"+seatNumbers);

                    System.out.println("bookingSeatsAvailable=true1;"+ bookingSeatsAvailable);

                }
                System.out.println("bookingSeatsAvailable=true2;"+ bookingSeatsAvailable);

            }
            System.out.println("bookingSeatsAvailable=true3;"+ bookingSeatsAvailable);


            movieSeatsRepository.save(movieSeats);
        

        // Send an acknowledgement to the ticket service

        if(bookingSeatsAvailable) {
        	InitiatePaymentCommand initiatePaymentCommand=new InitiatePaymentCommand(reserveSeatCommand.getBookingId(),reserveSeatCommand.getAmount(),reserveSeatCommand.getSeats());
            kafkaTemplate.send("initiatePaymentTopic", initiatePaymentCommand);
            System.out.println("Next step:initiatePaymentTopic");
        }
        else{
        	BookingCancelledTopic bookingCancelledTopic=new BookingCancelledTopic();
        	bookingCancelledTopic.setBookingId(reserveSeatCommand.getBookingId());
        	
            kafkaTemplate.send("bookingCancelledTopic", bookingCancelledTopic);
            System.out.println("Next step:cancelBooking");

        }

    }








    BookingSagaOrchestrator(){
    	
    }

}

