package com.patient.springBoot.mongoDB.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import com.patient.springBoot.mongoDB.models.Dataset;
import com.patient.springBoot.mongoDB.models.Ecg;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;


	
		  
		  @WritingConverter class EcgReadConverter implements Converter<Document, Ecg> {
		  @Autowired
				private MongoTemplate mongoTemplate;
		    @Override
		    public Ecg convert(Document source) {
		    	HashMap<String, List<Double>> myHashMap = new HashMap<>();
		        for (Map.Entry<String, Object> entry : source.entrySet()) {
		          myHashMap.put(entry.getKey(), (List<Double>) entry.getValue());
		          System.out.println(entry.getKey()+(List<Double>) entry.getValue());
		        }
		      //  Dataset d = new Dataset();
			    Dataset child = mongoTemplate.findById(source.getObjectId("dataset"), Dataset.class);
			    System.out.println("dataset");

		      return new Ecg(source.getObjectId("_id"), source.getString("uuid"),source.getObjectId("dataset"),child
		    		  ,source.getString("dataset_ecg_uuid"),source.getString("patient_id"),source.getBoolean("anonymized")
		    		 );
		    }
		    
		    
	      

		  }
		  
		  
		  
	






