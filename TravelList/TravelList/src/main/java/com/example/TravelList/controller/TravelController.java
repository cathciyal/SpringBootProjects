package com.example.TravelList.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TravelList.entity.Travel;
import com.example.TravelList.repository.TravelRepository;

@Controller
public class TravelController {
	
	@Autowired
	TravelRepository repository;
	
	@RequestMapping("/")
	@ResponseBody
	public String home(@RequestParam int id,String name,String des)
	{
		Travel travel=new Travel();
		travel.setName(name);
		travel.setId(id);
		travel.setDescription(des);
		repository.save(travel);
		return "Travel List Management";
	}
	
	@RequestMapping("/travelGetById/{id}")
	@ResponseBody
	public Optional<Travel> FindById(@PathVariable int id)
	{
		return repository.findById(id);
	}
	
	@RequestMapping("/travelDelete/{id}")
	@ResponseBody
	public String DeleteTravel(@PathVariable int id)
	{
		repository.deleteById(id);
		return "Deleted Successfully";
	}
	
	
	@RequestMapping("/updateTravel/{id}")
	@ResponseBody
	public String UpdateList(@PathVariable int id)
	{
		String name="My own wish updated";
		repository.updateTravel(name, id);
		Optional<Travel> travel1=repository.findById(id);
		return "Travel Updated successfully";
	}
	
	

	

}
