package com.example.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table( name="car",
schema="carrecord",
uniqueConstraints= {
		@UniqueConstraint(
				name= "carNo_unique",
				columnNames="carNo"
				)
        }
		)
public class Car {
	
	
	@Id
	@GeneratedValue(
			  
			  strategy = GenerationType.SEQUENCE,
				 generator = "car_generator"
			  )
	@SequenceGenerator(
				name="car_generator",
				sequenceName = "car_generator_name"
				)
	private int cardId;
	private String carModel;
	private String carNo;
	private String status;
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
