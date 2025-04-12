package org.task1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.task1.entity.Department;
import org.task1.repository.Departmentrepo;

@Service
public class Departmentservice {

	
	@Autowired
	private  Departmentrepo repo;
	
	
	
	public Departmentservice(Departmentrepo repo)
	{
	
		this.repo=repo;
	}
	
	
	
	public ResponseEntity<Department> adddeptarment(Department dept)
	{
		return ResponseEntity.ok(repo.save(dept));
	}
	
	public ResponseEntity<List<Department>> getallEmployee()
	{
		
		return ResponseEntity.ok(repo.findAll());
	}
	
	
	public ResponseEntity<Department> getemployeebyname(String name)
	{
		return ResponseEntity.ok(repo.findbyname(name));
	}
}
