package com.sapient.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sapient.vo.ShowTiming;


public interface ShowTimingRepository extends MongoRepository<ShowTiming, String> {
	   
	
	List<ShowTiming> findByTheatreId(String theatreId);
	
	@DeleteQuery("{'showTiming':?0,'theatreId': ?1}")
	void deleteByShowTimeAndTheatreId(Date showTiming,String theatreId);
	
	@Query("{'showTiming':?0,'theatreId': ?1}")
	ShowTiming findByTheatreIdAndShowTime(Date showTiming, String theatreId);

	
}
