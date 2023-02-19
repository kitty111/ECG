package com.patient.springBoot.mongoDB.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
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

@Service
public class EcgService {
	

	@Autowired
	private MongoTemplate mongoTemplate;
	

	 public List<Ecg> getAllEcg() {
			Query query = new Query();
		    query.fields().include("uuid").include("dataset").include("dataset_ecg_uuid")
		    .include("patient_id").include("anonymized");
		    query.limit(5);
		    List<Document> results = mongoTemplate.find(query, Document.class,"ecg");
		    List<Ecg> yourObjects = new ArrayList<>();
		    for (Document result : results) {
		    Ecg e= 	mongoTemplate.getConverter().read(Ecg.class, result);
		    Dataset child = mongoTemplate.findById(e.getDataset(), Dataset.class);
		      e.setD(child);
		      yourObjects.add(e);
		    	    }
		    
		    return yourObjects;
	 }
	 
	 public Ecg findECGById(ObjectId id) {
		 	ObjectId idd = new ObjectId("60d0c718959c0f7f5cdc16dc");
		 	Query query = new Query();
		    query.fields().include("_id").include("uuid").include("dataset").include("dataset_ecg_uuid")
		    .include("patient_id").include("anonymized");
		    query.addCriteria(Criteria.where("_id").is(idd));
		    Ecg ee = mongoTemplate.findOne(query, Ecg.class);
		    Dataset child = mongoTemplate.findById(ee.getDataset(), Dataset.class);
		      ee.setD(child);
		    System.out.println(ee.toString());
		    return ee ;
	 }
	 public ArrayList<Map<String, List<Double>>> getLeads() {
		 Query query = new Query();
		    query.fields().include("leads");
		    query.limit(2);
		    List<Document> results = mongoTemplate.find(query, Document.class,"ecg");
		    
		    List<Ecg> yourObjects = new ArrayList<>();
		    for (Document result : results) {
		    Ecg e= 	mongoTemplate.getConverter().read(Ecg.class, result);
		      yourObjects.add(e);
		    	    }
 
		 ArrayList<Map<String, List<Double>>> h = new ArrayList<>();
		 for(Ecg e : yourObjects) {
			 
			 h.add(e.getLeads());
		 }
		 
		    return h ;
	 }
	 
	 
	 
	 
	 /*public List<Ecg> findEcgs() {
	   Query query = new Query();
	   List<Ecg> attributes = new ArrayList<>();
	   mongoTemplate.find(query, Document.class, "ECG")
	      .forEach(doc -> {
	    	  Ecg ecg = new Ecg();
	    	  ecg.set_id(doc.get("_id"));
	    	  ecg.set_id(doc.get("annotations")
	    	  attributes.add(ecg);
	      });

	   return attributes;
	}*/

/*public void findEcgs(){
	List<Object> inventoryList = repo.findByStatusIncludeEmbeddedFields("7280f361-7ae3-4352-8b45-3abd25e476ac");

	System.out.println(inventoryList.toString());
}*/
	
}
