package org.task1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.task1.entity.Department;
import org.task1.Service.Departmentservice;

@RequestMapping("/dept")
@RestController
public class DepartmentController {
	
	
	
	@Autowired
	private Departmentservice service;
	
	
	@PostMapping("/add-dept")
	public ResponseEntity<Department> adddeptartment(@RequestBody Department dept)
	{
		
		return service.adddeptarment(dept);
	}
	
	
	@GetMapping("/get-all")
	public ResponseEntity<List<Department>> getallemployee()
	{
		return service.getallEmployee();
	}
	
	@GetMapping("/get-by-name")
	public ResponseEntity<Department> getemployeebyname(@RequestParam	String name)
	{
		return service.getemployeebyname(name);
	}

}
