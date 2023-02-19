package com.patient.springBoot.mongoDB.models;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Ecg {
	@Field("_id")
	private ObjectId _id;
	@Field("uuid")
	private String uuid;
	@Field("dataset")
	private ObjectId dataset;
	private Dataset d;
	@Field("dataset_ecg_uuid")
	private String dataset_ecg_uuid;
	@Field("patient_id")
	private String patient_id;
	@Field("anonymized")
	private Boolean anonymized;
	@Field("leads")
	private HashMap<String, List<Double>> leads;

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getDataset_ecg_uuid() {
		return dataset_ecg_uuid;
	}
	public void setDataset_ecg_uuid(String dataset_ecg_uuid) {
		this.dataset_ecg_uuid = dataset_ecg_uuid;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public Boolean getAnonymized() {
		return anonymized;
	}
	public void setAnonymized(Boolean anonymized) {
		this.anonymized = anonymized;
	}

	public Map<String, List<Double>> getLeads() {
		return leads;
	}
	public void setLeads(HashMap<String, List<Double>> leads) {
		this.leads = leads;
	}
	

	
	public Ecg(ObjectId _id, String uuid, ObjectId dataset,Dataset d ,String dataset_ecg_uuid, String patient_id,
			Boolean anonymized) {
		super();
		this._id = _id;
		this.uuid = uuid;
		this.d=d;
		this.dataset = dataset;
		this.dataset_ecg_uuid = dataset_ecg_uuid;
		this.patient_id = patient_id;
		this.anonymized = anonymized;
	//	this.leads = new HashMap<>();
		//this.leads = leads;
	
	}
	
	public ObjectId getDataset() {
		return dataset;
	}
	public void setDataset(ObjectId dataset) {
		this.dataset = dataset;
	}
	public Dataset getD() {
		return d;
	}
	public void setD(Dataset d) {
		this.d = d;
	}
	public Ecg() {
		// TODO Auto-generated constructor stub
	}
	public void put(String key, List<Double> value) {
		leads.put(key, value);
	  }

	  public List<Double> get(String key) {
	    return leads.get(key);
	  }
	@Override
	public String toString() {
		return "Ecg [_id=" + _id + ", uuid=" + uuid + ", dataset=" + dataset + ", d=" + d + ", dataset_ecg_uuid="
				+ dataset_ecg_uuid + ", patient_id=" + patient_id + ", anonymized=" + anonymized + ", leads=" + leads
				+ "]";
	}

	
	
	
}
