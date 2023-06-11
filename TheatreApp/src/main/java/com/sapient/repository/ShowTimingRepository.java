package com.sapient.repository;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sapient.vo.ShowTiming;


public interface ShowTimingRepository extends ReactiveMongoRepository<ShowTiming, String> {
	   
	
	List<ShowTiming> findByTheatreId(String theatreId);
	
	@DeleteQuery("{'showTiming':?0,'theatreId': ?1}")
	void deleteByShowTimeAndTheatreId(ZonedDateTime zonedDateTime,String theatreId);
	
	@Query("{'showTiming':?0,'theatreId': ?1}")
	ShowTiming findByTheatreIdAndShowTime(ZonedDateTime showTiming, String theatreId);

	
}
