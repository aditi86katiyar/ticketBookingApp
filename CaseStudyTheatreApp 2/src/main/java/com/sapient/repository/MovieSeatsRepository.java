package com.sapient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sapient.vo.MovieSeat;


public interface MovieSeatsRepository extends MongoRepository<MovieSeat, Long> {
	   List<MovieSeat> findByTheatreId(String theatreId, String seatNumber, String seatType);

	@Query("{'theatreName' : ?0 ,'seatNumber' : ?1,'seatType' : ?2}")
	MovieSeat findByTheatreIdAndSeat(String id, int seatNumber, String seatType);
}
