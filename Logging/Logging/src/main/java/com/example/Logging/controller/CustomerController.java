package com.example.Logging.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Logging.entity.Customer;
import com.example.Logging.repository.CustomerRepository;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository repo;
	
	
	
	@RequestMapping("/checkIn")
	@ResponseBody
	public ResponseEntity<List<Customer>> getProductsByType(@RequestParam String name)
     {
    	 
    	 Customer customer=new Customer();
    	 customer.setLogType("IN");
    	 LocalDate date=LocalDate.now();
    	 LocalTime time=LocalTime.now();
    	 customer.setDate(date.toString());
    	 customer.setTime(time.toString());
    	 customer.setId(name+time);
    	 customer.setName(name);
    	 String id=name+time;
    	 repo.save(customer);
       return new ResponseEntity<List<Customer>>(repo.findByIdLike("%"+id+"%"), HttpStatus.OK);
    	 
    	 
    	 
     }
	

    @RequestMapping("/checkOut")
 	@ResponseBody
	public ResponseEntity<List<Customer>> getCustomersByType(@RequestParam String name) {
		Customer customer=new Customer();
   	 customer.setLogType("OUT");
   	 LocalDate date=LocalDate.now();
   	 LocalTime time=LocalTime.now();
	 customer.setDate(date.toString());
	 customer.setTime(time.toString());
	 customer.setName(name);
   	 customer.setId(name+time);
   	 String id=name+time;
   	 repo.save(customer);
   	return new ResponseEntity<List<Customer>>(repo.findByIdLike("%"+id+"%"), HttpStatus.OK);
	}
    
    @RequestMapping("/getAllLog")
    @ResponseBody
    public List<Customer> getAll()
    {
    	return repo.findAll();
    }
    
    @RequestMapping("/getLog")
    @ResponseBody
    public List<Customer> getCustomersByDate(@RequestParam String date)
    {
    	List<Customer> cus=repo.findByDateLike(date);
    	return cus;	
    }
    
    
   
   

}
