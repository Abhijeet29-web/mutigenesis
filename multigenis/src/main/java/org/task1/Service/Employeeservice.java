package org.task1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.task1.entity.Employee;
import org.task1.repository.Employeerepo;

@Service
public class Employeeservice {
	
	@Autowired
	private Employeerepo repo;
	
	
	public Employeeservice(Employeerepo repo)
	{
		this.repo=repo;
	}
	
	
	
	public ResponseEntity<Employee> addemp(@RequestBody Employee emp)
	{
		return ResponseEntity.ok(repo.save(emp));
	}
	
	
	
	public ResponseEntity<List<Employee>> getbydesignation(String designation) throws Exception
	{
		if(designation ==null)
		{
			throw new Exception("Something went wrong...!");
		}
		
		return ResponseEntity.ok(repo.findbydesignation(designation));
	}
	
	
	
	public ResponseEntity<List<Employee>> findsalarybyrange(double start, double end)
	{
		
		return ResponseEntity.ok(repo.findwithinrange(start, end));
	}
	
	public ResponseEntity<Page<Employee>> getPaginatedEmployees(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Employee> employeePage = repo.findAll(pageable);
	    return ResponseEntity.ok(employeePage);
	}

	

}
