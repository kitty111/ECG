package com.patient.springBoot.mongoDB.models;



import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class ClinicalData {
	@Field("_id")
	private ObjectId _id;
	@Field("ecg")
	private ObjectId ecg;
	private Ecg ecgg;
	@Field("dataset")
	private ObjectId dataset;
	@Field("recording.started_at")
	private Date started_at;
	@Field("recording.ended_at")
	private Date ended_at;
	@Field("recording.sampling_rate")
	private int sampling_rate;
	@Field("recording.visit.name")
	private String visit_name;
	@Field("recording.duration")
	private String duration ;
	@Field("patient.age")
	private int age;
	@Field("patient.birth_date")
	private Date birth_date;
	@Field("patient.height")
	private String height;
	@Field("patient.weight")
	private String weight;
	@Field("patient.sex")
	private String sex;
	@Field("patient.race")
	private String race;
	@Field("patient.observation")
	private String observation;
	
	public Date getEnded_at() {
		return ended_at;
	}
	
	public Ecg getEcgg() {
		return ecgg;
	}

	public void setEcgg(Ecg ecgg) {
		this.ecgg = ecgg;
	}

	public void setEnded_at(Date ended_at) {
		this.ended_at = ended_at;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}

	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public ObjectId getEcg() {
		return ecg;
	}
	public void setEcg(ObjectId ecg) {
		this.ecg = ecg;
	}
	public ObjectId getDataset() {
		return dataset;
	}
	public void setDataset(ObjectId dataset) {
		this.dataset = dataset;
	}
	public Date getStarted_at() {
		return started_at;
	}
	public void setStarted_at(Date started_at) {
		this.started_at = started_at;
	}
	public int getSampling_rate() {
		return sampling_rate;
	}
	public void setSampling_rate(int sampling_rate) {
		this.sampling_rate = sampling_rate;
	}
	public String getVisit_name() {
		return visit_name;
	}
	public void setVisit_name(String visit_name) {
		this.visit_name = visit_name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public ClinicalData(ObjectId _id, ObjectId ecg, Ecg ecgg, ObjectId dataset, Date started_at, Date ended_at,
			int sampling_rate, String visit_name, String duration, int age, Date birth_date, String height,
			String weight, String sex, String race, String observation) {
		super();
		this._id = _id;
		this.ecg = ecg;
		this.ecgg = ecgg;
		this.dataset = dataset;
		this.started_at = started_at;
		this.ended_at = ended_at;
		this.sampling_rate = sampling_rate;
		this.visit_name = visit_name;
		this.duration = duration;
		this.age = age;
		this.birth_date = birth_date;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		this.race = race;
		this.observation = observation;
	}
	
	
}
