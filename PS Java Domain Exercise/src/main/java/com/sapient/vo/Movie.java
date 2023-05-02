package com.sapient.vo;

public class Movie {
	
	String movieName;
	
	MOVIE_STATUS movieAvailable;
	
	String movieLanguage;
	
	float rating;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public MOVIE_STATUS getMovieAvailable() {
		return movieAvailable;
	}

	public void setMovieAvailable(MOVIE_STATUS movieAvailable) {
		this.movieAvailable = movieAvailable;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Movie(String movieName, MOVIE_STATUS movieAvailable, float rating) {
		super();
		this.movieName = movieName;
		this.movieAvailable = movieAvailable;
		this.rating = rating;
	}

public Movie() {
	
}

	
}
