package com.example.TravelList.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table( name="travel",
schema="Travemanagement"
		)
public class Travel {
	
	@Id
	@GeneratedValue(
			  
			  strategy = GenerationType.SEQUENCE,
				 generator = "travel_generator"
			  )
	@SequenceGenerator(
				name="travel_generator",
				sequenceName = "travel_generator_name"
				)
	private int id;
	private String name;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	

}
