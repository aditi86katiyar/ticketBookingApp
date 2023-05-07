package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingSagaOrchestrator {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    
   

    @KafkaListener(topics = "initiatePaymentTopic",groupId = "seats-consumer")

    public void handleinitiatePaymentTopic(InitiatePaymentCommand paymentCompletedEvent) {
    	String bookingId = paymentCompletedEvent.getBookingId();
        // Send a booking confirmation to the customer
    	System.out.println("initiatePaymentTopic");
        kafkaTemplate.send("paymentCompletedTopic", bookingId);
    }
    
    @KafkaListener(topics = "paymentCompletedTopic",groupId = "seats-consumer")
    public void handlePaymentCompletedEvent(PaymentCompletedEvent paymentCompletedEvent) {
    	String bookingId = paymentCompletedEvent.getBookingId();
    	BookingConfirmedEvent bookingConfirmedEvent=new BookingConfirmedEvent();
    	bookingConfirmedEvent.setBookingId(bookingId);
    	
        // Send a booking confirmation to the customer
    	System.out.println("paymentCompletedTopic");

        kafkaTemplate.send("bookingConfirmedTopic", bookingId);

    }
    
    @KafkaListener(topics = "bookingConfirmedTopic",groupId = "seats-consumer")
    public void handleBookingConfirmedTopic(BookingConfirmedEvent paymentCompletedEvent) {
    	String bookingId = paymentCompletedEvent.getBookingId();
        // Send a booking confirmation to the customer
    	System.out.println("bookingConfirmedTopic");


    }
    
    @KafkaListener(topics = "bookingCancelledTopic",groupId = "seats-consumer")
    public void handleBookingCancelledTopic(BookingCancelledTopic paymentCompletedEvent) {
    	String bookingId = paymentCompletedEvent.getBookingId();
        // Send a booking confirmation to the customer
    	System.out.println("bookingCancelledTopic");


    }
}

