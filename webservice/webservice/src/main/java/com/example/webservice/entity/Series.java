package com.example.webservice.entity;

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
		name="series",
		schema="webseries",
		uniqueConstraints= {
				@UniqueConstraint(
						name= "season_unique",
						columnNames="seasons"
						)
		}
		)
public class Series {
	
	
	@Id
	@GeneratedValue(
			 strategy = GenerationType.SEQUENCE,
			 generator = "series_generator"
			)
	@SequenceGenerator(
			name="series_generator",
			sequenceName = "series_generator_name"
			)
	private int id;
	
	
	private String name;
	
	
	private int seasons;
	
	
	private int episodes;
	
	
	private int rating;
	
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
	public int getSeasons() {
		return seasons;
	}
	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}
	public int getEpisodes() {
		return episodes;
	}
	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	

}
