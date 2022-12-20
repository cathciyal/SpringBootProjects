package com.example.car.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.car.entity.Car;
import com.example.car.repository.CarRepository;

@Controller
public class CarController {
	
	@Autowired
	private CarRepository repository;
	
	@RequestMapping("/")
	@ResponseBody
	public String home(@RequestParam int cardid,String carmodel,String carno,String status)
	{
		
		Car car=new Car();
		car.setCardId(cardid);
		car.setCarModel(carmodel);
		car.setCarNo(carno);
		car.setStatus(status);
		repository.save(car);
		return "Welcome to Car Rental Management";
	}
	
	@RequestMapping("/saveCar")
	@ResponseBody
	public List<Car> GetCar()
	{
		return repository.findAll();
	}
	
	@RequestMapping("/getCars")
	@ResponseBody
	public List<Car> GetAllCar()
	{
		return repository.findAll();
	}
	
	@RequestMapping("/deleteCar")
	@ResponseBody
	public String DeleteCar(@RequestParam int id)
	{
		repository.deleteById(id);
		return "Car with id "+id+" is deleted Successfully";
	}
	
	@RequestMapping("/editCar")
	@ResponseBody
	public Optional<Car> EditCar(@RequestParam int id)
	{
		String status1="Completed";
		repository.updateTask(status1, id);
		Optional<Car> Car1=repository.findById(id);
		return Car1;
	}
	
	@RequestMapping("/getCar")
	@ResponseBody
	public Optional<Car> GetCarById(@RequestParam int id)
	{
		return repository.findById(id);
	}

}
