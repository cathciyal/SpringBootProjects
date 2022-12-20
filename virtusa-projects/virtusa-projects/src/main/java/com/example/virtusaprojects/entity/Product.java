package com.example.virtusaprojects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name="product",
		schema="library",
		uniqueConstraints= {
				@UniqueConstraint(
						name= "quan_unique",
						columnNames="Quantity"
						)
		}
		)
public class Product {
	
	
	@Id
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="product_generator"
			)
	
	@SequenceGenerator(
			
			name="product_generator",
			sequenceName="product_sequence_name"
			)
	private int Boodid;
	
	
	@Column(nullable=false)
	private int Quantity;
	private String BookName;
	private String genre;
	
	
   
	
	
	
	
	
	public int getBoodid() {
		return Boodid;
	}
	public void setBoodid(int boodid) {
		Boodid = boodid;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	

}
