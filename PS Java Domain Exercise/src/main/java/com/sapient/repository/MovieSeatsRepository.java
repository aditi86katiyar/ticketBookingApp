package com.sapient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.vo.MovieSeats;

@Repository
public interface MovieSeatsRepository extends MongoRepository<MovieSeats, String> {
	

	@Query("{theatreId: ?0}")
	MovieSeats findByTheatreId(String theatreId);
    
	
}
