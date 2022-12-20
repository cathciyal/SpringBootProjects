package com.example.Employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Employee.entity.Employee;
import com.example.Employee.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@RequestMapping("/")
	@ResponseBody
	public String home(@RequestParam int id,String name,String email,String dept)
	{
		Employee employee=new Employee();
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		employee.setEmployeeEmail(email);
		employee.setDept(dept);
		repository.save(employee);
		return "home";
	}
	
	@RequestMapping("/addEmployee")
	@ResponseBody
	public List<Employee> addEmployee()
	{
		return repository.findAll();
	}
	
	@RequestMapping("/deleteEmployee")
	@ResponseBody
	public String DeleteEmployee(@RequestParam int id)
	{
		repository.deleteById(id);
		return "deleted successfully";
	}
	
	@RequestMapping("/getEmployee")
	@ResponseBody
	public Optional<Employee> getEmployeeById(@RequestParam int id)
	{
		return repository.findById(id);
	}
	

}
