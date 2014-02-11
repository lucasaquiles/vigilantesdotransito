package com.appspot.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Occurrency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOccurrency;
	private String plate;
	private String type;
	private String description;
	private Date date;
	
	public Occurrency(){
		
	}

	public Occurrency(String plate, String type, String description, Date date) {
		super();
		this.plate = plate;
		this.type = type;
		this.description = description;
		this.date = date;
	}

	public Long getIdOccurrency() {
		return idOccurrency;
	}

	public void setIdOccurrency(Long idOccurrency) {
		this.idOccurrency = idOccurrency;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getFormattedDate(){
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");  
		return spf.format(this.getDate());  
	}
}
