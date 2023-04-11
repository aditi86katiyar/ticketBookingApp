package com.sapient.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.CompoundIndexDefinition;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import org.springframework.stereotype.Component;

@Component
public class IndexCreator {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void createIndexes() {
		
		IndexDefinition index=new CompoundIndexDefinition(new Document().append("theatreName", 1).append("movie", 1));
		mongoTemplate.indexOps("theatre")
			.ensureIndex(index);
	}

}
