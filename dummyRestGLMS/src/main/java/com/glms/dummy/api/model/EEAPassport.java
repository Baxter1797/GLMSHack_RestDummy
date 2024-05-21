package com.glms.dummy.api.model;

public class EEAPassport {
	private int id;
	private String name;
	private String jurisdiction;
	private String regulator;
	private String activeDate;
	private String expiryDate;
	private String entity;
	private String status;
	
	public EEAPassport(int id, String name, String jurisdiction, String regulator, String activeDate, String expiryDate, String entity, String status) {
		this.id = id;
		this.name = name;
		this.jurisdiction = jurisdiction;
		this.regulator = regulator;
		this.activeDate = activeDate;
		this.expiryDate = expiryDate;
		this.entity = entity;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public String getRegulator() {
		return regulator;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getEntity() {
		return entity;
	}

	public String getStatus() {
		return status;
	}
	
}
