package org.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.task1.entity.Department;
public interface Departmentrepo extends JpaRepository<Department, Integer> {
	
	
	
	@Query(value="select * from department where name= :nm", nativeQuery=true)
	public Department findbyname(@Param("nm") String nm);

}
