package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

@EnableJpaRepositories
@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
	
	@Query("Select o from Employee o where o.eName=?1")
	public Employee getEmpByName(String eName);

}
