package com.sapient.vo;


import java.time.LocalTime;

public class MovieTimings {
	
	Long movie_timing_id;
	
	LocalTime movieTiming;

	public MovieTimings(LocalTime localTime) {
		super();
		this.movieTiming = localTime;
	}

	@Override
	public String toString() {
		return "MovieTimings [movie_timing_id=" + movie_timing_id + ", movieTiming=" + movieTiming + "]";
	}
	
	
	

}
