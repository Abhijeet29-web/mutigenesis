package org.task1.repository;


import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.task1.entity.Employee;

public interface Employeerepo extends JpaRepository<Employee, Integer> {

	
	
	
	@Query(value="select * from Employee where designation= :dn", nativeQuery=true)
	public List<Employee> findbydesignation(@Param("dn") String dn);
	
	
	
	@Query(value="select * from employee where salary between :start and  :end;", nativeQuery=true)
	public List<Employee> findwithinrange(@Param("start") double start, @Param("end") double end);
	
	
	
    Page<Employee> findAll(Pageable pageable);

	
}
