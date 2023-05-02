package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

public class BookingSagaOrchestrator {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void handleBookingCreatedEvent(BookingCreatedEvent bookingCreatedEvent) {
        Long bookingId = bookingCreatedEvent.getBookingId();
        Double amount = bookingCreatedEvent.getPaymentAmount();
        kafkaTemplate.send("initiatePaymentTopic", new InitiatePaymentCommand(bookingId, amount));
        kafkaTemplate.send("seatReservedTopic", new ReserveSeatCommand(bookingId,bookingCreatedEvent.getTheatreId(),bookingCreatedEvent.getSeats()));
        
    }

    @KafkaListener(topics = "seatReservedTopic")
    public void handleTicketReservedEvent(ReserveSeatCommand ticketReservedEvent) {
        Long bookingId = ticketReservedEvent.getBookingId();
        // Send an acknowledgement to the ticket service
        kafkaTemplate.send("ticketReservationAcknowledgedTopic", bookingId);
    }

    @KafkaListener(topics = "paymentCompletedTopic")
    public void handlePaymentCompletedEvent(PaymentCompletedEvent paymentCompletedEvent) {
        Long bookingId = paymentCompletedEvent.getBookingId();
        // Send a booking confirmation to the customer
        kafkaTemplate.send("bookingConfirmedTopic", bookingId);
    }
}

