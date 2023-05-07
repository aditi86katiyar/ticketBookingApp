package com.sapient.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.vo.Booking;

@Service
public class KafkaService {

    @Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
  
    @Autowired
    public KafkaService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void produce(String topic, ReserveSeatCommand message) {
        	ObjectMapper objectMapper=new ObjectMapper();
            	kafkaTemplate.send(topic, message);
				System.out.println("Message pushed to kafka" +message );
			
}
}