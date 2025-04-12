package org.task1.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.task1.entity.Salary;

import org.task1.entity.Employee;



public interface Salaryrepo extends JpaRepository<Salary, Integer> {
	
	
	
	@Query(value="select * from salary where amount between :one and :two",nativeQuery=true)
	public List<Salary> findwithinrange(@Param("one") double one, @Param("two") double two);

}
