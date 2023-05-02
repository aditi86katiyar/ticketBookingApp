package com.sapient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.vo.MovieSeat;

@Repository
public interface MovieSeatsRepository extends MongoRepository<MovieSeat, String> {
	

	@Query("{theatreId: ?0, seatType: ?1, seatNumber: {$in: ?2}}")
	List<MovieSeat> findByTheatreIdAndSeatTypeAndSeatNumberIn(String theatreId, String seatType, List<String> seatNumbers);
    
	
    @Query("{theatreId: ?0, seatType: ?1, seatNumber: {$in: ?2}}")
    void updateSeatTypeAndStatus(String theatreId,String seatType, List<String> seatNumbers);
}
