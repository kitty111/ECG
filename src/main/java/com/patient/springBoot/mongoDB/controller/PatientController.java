package com.patient.springBoot.mongoDB.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.patient.springBoot.mongoDB.models.ClinicalData;
import com.patient.springBoot.mongoDB.services.PatientService;

import jakarta.websocket.server.PathParam;

@RestController
public class PatientController {
	@Autowired 
	PatientService p;

	public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
	
	@PostMapping("/addECGAndPatient")
	public String saveECG() throws Exception {
		 MongoClient mongo = MongoClients.create();
			MongoDatabase database = mongo.getDatabase("ecg_db");
		      Document document = new Document();
			 String file = "src/main/resources/data1.json";
		        String json = readFileAsString(file);
			  System.out.println(json);
			  Document d =  Document.parse(json);
			  database.getCollection("ecg").insertOne(d);
		return ("ECG added");
		
	}
	
	@GetMapping("/getPatients")
	public List<ClinicalData> getAllPatient(){
		return p.getAllPatient();
	}
	
	
	
}


