package com.sapient.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sapient.vo.MovieSeats;

public interface MovieSeatsRepository extends MongoRepository<MovieSeats, Long> {
	
	@Query("{'theatreName': ?0, 'movieName' : ?1 , 'theatreAddress.city' : ?2, 'movieTiming': { $eq: ?3}, 'movieSeats' :{ $elemMatch : {'seatNumber' :?4,'seatType' :?5}}}")
	MovieSeats findSeatsByMovieName(String theatreName, String movieName,String city, Date showTimings, String seatNumber, String  seatPrefernce);
	

}
