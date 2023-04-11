package com.sapient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.vo.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, Long> {

}
