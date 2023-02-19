package com.patient.springBoot.mongoDB.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.patient.springBoot.mongoDB.models.ClinicalData;
import com.patient.springBoot.mongoDB.models.Dataset;
import com.patient.springBoot.mongoDB.models.Ecg;



@Service
public class PatientService {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	 public List<ClinicalData> getAllPatient() {
		 Query query = new Query();
		   /* query.fields().include("_id").include("ecg").include("ecgg").include("dataset")
		    
		   .include("patient.age")
		   .include("recording.sampling_rate")
		    .include("patient.height").include("patient.weight")
		    .include("patient.sex").include("patient.race").include("patient.observation");
		 //   query.addCriteria(Criteria.where("patient.birth_date").exists(false));
		   // query.addCriteria(Criteria.where("sampling_rate").exists(true).orOperator(Criteria.where("sampling_rate").exists(false)));
		   query.addCriteria(Criteria.where("patient.age").exists(true).orOperator(Criteria.where("patient.age").exists(false)));
		    query.addCriteria(Criteria.where("patient.birth_date").exists(true).orOperator(Criteria.where("patient.birth_date").exists(false)));
		    query.addCriteria(Criteria.where("patient.weight").exists(true).orOperator(Criteria.where("patient.weight").exists(false)));
		    query.addCriteria(Criteria.where("patient.height").exists(true).orOperator(Criteria.where("patient.height").exists(false)));
		    query.addCriteria(Criteria.where("patient.sex").exists(true).orOperator(Criteria.where("patient.sex").exists(false)));
		    query.addCriteria(Criteria.where("patient.observation").exists(true).orOperator(Criteria.where("patient.observation").exists(false)));
*/
		 
		 //   query.limit(2);
		    Aggregation aggregation = Aggregation.newAggregation(
		    		  Aggregation.project().and(ConditionalOperators.ifNull("age").then("null")).as("age")
		    		  .and(ConditionalOperators.ifNull("sampling_rate").then("100")).as("sampling_rate")
		    		);

		    		AggregationResults<ClinicalData> results = mongoTemplate.aggregate(aggregation, "ecg_clinical_data", ClinicalData.class);
		    		List<ClinicalData> finalResult = results.getMappedResults();


		    return finalResult;
	 }
	
	 
}
