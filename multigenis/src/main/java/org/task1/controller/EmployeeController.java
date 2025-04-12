package org.task1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.task1.Service.Employeeservice;

import org.task1.entity.Employee;



@RestController
public class EmployeeController {
	
	
	
	@Autowired
	private Employeeservice service;
	
	
	
	@PostMapping("/add-emp")
	public ResponseEntity<Employee> saveemp(@RequestBody Employee emp)
	{
		return service.addemp(emp);
	}
	
	
	
	@GetMapping("/get-desg")
	public ResponseEntity<List<Employee>> getEmployeeByDesignation(@RequestParam("desg") String desg) throws Exception
	{
		
		System.out.println("service hit .");
		return service.getbydesignation(desg);
	}
	
	
	
	@GetMapping("/get-within-range/{start}/{end}")
	public ResponseEntity<List<Employee>> getwithinrange(@PathVariable("start") double start, @PathVariable("end") double end)
	{
		
		return service.findsalarybyrange(start, end);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Page<Employee>> getPaginatedEmployees(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {
	    return service.getPaginatedEmployees(page, size);
	}

	
}
