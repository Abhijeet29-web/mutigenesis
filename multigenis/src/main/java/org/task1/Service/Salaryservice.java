package org.task1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.task1.entity.Salary;
import org.task1.repository.Salaryrepo;

@Service
public class Salaryservice {
	
	@Autowired
	private Salaryrepo repo;
	
	
	
	public Salaryservice(Salaryrepo repo)
	{
		this.repo=repo;
	}
	
	
	
	public ResponseEntity<Salary> addemployeesalary(Salary salary)
	{
		return ResponseEntity.ok(repo.save(salary));
		
	}

	
	
	public List<Salary> getsalarywithin(double first, double second)
	{
		return repo.findwithinrange(second, second);
	}
	
	
	public List<Salary> getallsalary()
	{
		return repo.findAll();
	}
}
