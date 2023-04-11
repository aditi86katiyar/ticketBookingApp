package com.sapient.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver{
	
	private TheatreRepository theatreRepository;
	
	@Autowired
	public Query(TheatreRepository theatreRepository) {
		this.theatreRepository=theatreRepository;
	}

}
