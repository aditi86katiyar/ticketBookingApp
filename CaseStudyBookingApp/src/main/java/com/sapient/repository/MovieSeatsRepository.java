package com.sapient.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.vo.MovieSeats;

@Repository
public interface MovieSeatsRepository extends MongoRepository<MovieSeats, Long> {
	
	@Query("{'movie.movieName' : ?0 , 'address.city' : ?1, 'movieTiming': { $eq: ?2}}")
	MovieSeats findSeatsByMovieName(String movieName, Date showTimings);
	

}
