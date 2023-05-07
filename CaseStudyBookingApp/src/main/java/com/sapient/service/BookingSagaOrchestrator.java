package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

public class BookingSagaOrchestrator {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    
   

    @KafkaListener(topics = "initiatePaymentTopic")
    public void handleinitiatePaymentTopic(InitiatePaymentCommand paymentCompletedEvent) {
    	String bookingId = paymentCompletedEvent.getBookingId();
        // Send a booking confirmation to the customer
    	System.out.println("initiatePaymentTopic");
        kafkaTemplate.send("paymentCompletedTopic", bookingId);
    }
    
    @KafkaListener(topics = "paymentCompletedTopic")
    public void handlePaymentCompletedEvent(PaymentCompletedEvent paymentCompletedEvent) {
    	String bookingId = paymentCompletedEvent.getBookingId();
        // Send a booking confirmation to the customer
        kafkaTemplate.send("bookingConfirmedTopic", bookingId);
    }
}

