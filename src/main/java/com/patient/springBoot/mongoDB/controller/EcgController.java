package com.patient.springBoot.mongoDB.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.patient.springBoot.mongoDB.models.Ecg;
import com.patient.springBoot.mongoDB.services.EcgService;

import jakarta.websocket.server.PathParam;

@RestController
public class EcgController {

	
	@Autowired 
	EcgService e;
	

	@GetMapping("/getEcgs")
	public List<Ecg> getAllEcg(){
		return e.getAllEcg();
	}
	@GetMapping("/getLeads")
	public ArrayList<Map<String, List<Double>>> getLeads(){
		return e.getLeads();
	}
	
	@GetMapping("/findById/{id}")
	public Ecg findById(@PathVariable("id") ObjectId id){
		return e.findECGById(id);
	}
}
