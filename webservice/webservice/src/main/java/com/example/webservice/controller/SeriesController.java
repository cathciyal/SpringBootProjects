package com.example.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.webservice.entity.Series;
import com.example.webservice.repository.SeriesRepository;

@Controller
public class SeriesController {
	
@Autowired
private SeriesRepository repository;
	
@RequestMapping("/")
@ResponseBody
public String home(@RequestParam int id,String name,int seasons,int episodes,int rating)
{
	
	Series series1=new Series();
	series1.setId(id);
	series1.setName(name);
	series1.setSeasons(seasons);
	series1.setEpisodes(episodes);
	series1.setRating(rating);
	repository.save(series1);
	return "Welcome to webSeries Management";
}

@RequestMapping("/series")
@ResponseBody
public List<Series> getSeries()
{
	
	return repository.findAll();
}

@RequestMapping("/series/id/{id}")
@ResponseBody
public Optional<Series> getSeriesById(@PathVariable int id)
{
	
	return repository.findById(id);
}
@RequestMapping("/series/name/{name}")
@ResponseBody
public ResponseEntity<List<Series>> getProductsByType(@PathVariable String name) {
		return new ResponseEntity<List<Series>>(repository.findBynameLike("%"+name+"%"), HttpStatus.OK);
	}


@RequestMapping("/delete/{id}")
@ResponseBody
public String deleteSeries(@PathVariable int id)
{

    repository.deleteById(id);
	return "Series Removed !"+id;
}

@RequestMapping("/update/{id}/{name}")
@ResponseBody
public Optional<Series> updateSeries(@PathVariable int id,@PathVariable String name)
{
	repository.updateSeries(name, id);
	Optional<Series> series=repository.findById(id);
	return series;
	
		
	
   
	
    
}
    
}


