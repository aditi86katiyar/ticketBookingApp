package com.sapient.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.vo.MovieSeats;

@Configuration
public interface MovieSeatsRepository extends ReactiveMongoRepository<MovieSeats, String> {
	

	@Query("{theatreId: ?0}")
	MovieSeats findByTheatreId(String theatreId);
    
	
}
