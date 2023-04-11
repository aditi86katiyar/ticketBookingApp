package com.sapient.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sapient.vo.Movie;
import com.sapient.vo.Theatre;

public interface TheatreRepository extends MongoRepository<Theatre, Long> {
	
	@Query("{'theatreName' : ?0 , 'movie' : ?1}")
	Theatre findByTheatreName(String theatreName, Movie movie);
	
	@Query("{'movie.movieName' : ?0 , 'address.city' : ?1, 'movieTiming': { $eq: ?2}}")
	Theatre findByTheatreNameLocAndShowTimings(String movieName, String location, List<Date> movieTiming);
	
	

}
