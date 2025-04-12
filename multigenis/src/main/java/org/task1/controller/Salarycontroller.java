package org.task1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.task1.Service.Salaryservice;

import org.task1.entity.Salary;


@RequestMapping("/salary")
@RestController
public class Salarycontroller {
	
	
	@Autowired
	private Salaryservice service;
	
	
	
	@PostMapping("/add-sal")
	public ResponseEntity<Salary> addsalary(@RequestBody Salary salary)
	{
		
		return service.addemployeesalary(salary);
	}
	
	
	@GetMapping("/get-within/{first}/{second}")
	public List<Salary> getraneg(@PathVariable("first") double first, @PathVariable("second") double second)
	{
		
		return service.getsalarywithin(first, second);
	}
 
	
	@GetMapping("/get-all")
	public List<Salary> getallc()
	{
		return service.getallsalary();
	}

}
