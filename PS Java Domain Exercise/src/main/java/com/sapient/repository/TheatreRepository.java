package com.sapient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sapient.vo.Movie;
import com.sapient.vo.Theatre;

public interface TheatreRepository extends MongoRepository<Theatre, Long> {
	
	@Query("{'theatreName' : ?0 , 'movie' : ?1}")
	Theatre findByTheatreName(String theatreName, Movie movie);
	
	@Query("{'theatreName' : ?0,'movie.movieName' : ?1,'address.city' : ?2}")
	Theatre findByTheatreNameMovieNameCity(String theatreName, String movieName,String city);

	@Query("{'movie.movieName' : ?0,'address.city' : ?1}")
	List<Theatre> findByMovieNameCity(String movieName, String city);

	
	
	

}
