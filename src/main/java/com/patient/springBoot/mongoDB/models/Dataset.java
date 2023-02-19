package com.patient.springBoot.mongoDB.models;



import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Dataset {
	@Field("_id")
	private ObjectId _id;
	@Field("name")
	private String name;
	@Field("description")
	private String description;
	@Field("aquisition_date")
	private Date aquisition_date;
	@Field("leads_name")
	private String leads_name;
	@Field("study.name")
	private String study;
	@Field("source.name")
	private String source;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getAquisition_date() {
		return aquisition_date;
	}
	public void setAquisition_date(Date aquisition_date) {
		this.aquisition_date = aquisition_date;
	}
	public String getLeads_name() {
		return leads_name;
	}
	public void setLeads_name(String leads_name) {
		this.leads_name = leads_name;
	}
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Override
	public String toString() {
		return "Dataset [_id=" + _id + ", name=" + name + ", description=" + description + ", aquisition_date="
				+ aquisition_date + ", leads_name=" + leads_name + ", study=" + study + ", source=" + source + "]";
	}
	
	

}
