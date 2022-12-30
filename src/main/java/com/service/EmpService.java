package com.service;

import com.entity.Employee;
import com.exceptions.ResourceNotFoundException;

public interface EmpService {
	
	Employee addEmp(Employee e) throws Exception;

	Employee updateEmp(Employee e, int id) throws Exception;

	Employee getEmp(int id) throws ResourceNotFoundException;

	Boolean deleteEmp(int id) throws ResourceNotFoundException;

}
