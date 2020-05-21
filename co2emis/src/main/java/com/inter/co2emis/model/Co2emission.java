package com.inter.co2emis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Co2emission")
public class Co2emission {
	
	@Id
	private long id;
	private String vehicletype;
	private String unitofmeasure;
	private int traveldistance;
	private int co2emissionperingram;
	
	public Co2emission() {
		super();
	}

	public Co2emission(long id, String vehicletype, String unitofmeasure, int traveldistance,
			int co2emissionperingram) {
		super();
		this.id = id;
		this.vehicletype = vehicletype;
		this.unitofmeasure = unitofmeasure;
		this.traveldistance = traveldistance;
		this.co2emissionperingram = co2emissionperingram;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getUnitofmeasure() {
		return unitofmeasure;
	}

	public void setUnitofmeasure(String unitofmeasure) {
		this.unitofmeasure = unitofmeasure;
	}

	public int getTraveldistance() {
		return traveldistance;
	}

	public void setTraveldistance(int traveldistance) {
		this.traveldistance = traveldistance;
	}

	public int getCo2emissionperingram() {
		return co2emissionperingram;
	}

	public void setCo2emissionperingram(int co2emissionperingram) {
		this.co2emissionperingram = co2emissionperingram;
	}


	

}
