package com.sapient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.vo.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
