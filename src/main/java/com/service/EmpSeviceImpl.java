package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.exceptions.ResourceNotFoundException;
import com.repo.EmpRepo;

@Service
public class EmpSeviceImpl implements EmpService {

	@Autowired
	private EmpRepo  empRepoo;
	
	@Override
	public Employee addEmp(Employee e) throws Exception {
		Employee emp=empRepoo.getEmpByName(e.getEName());
		
		
		if(emp!=null)
		{
			throw new Exception("Employee Already exists");
		}
		return empRepoo.save(e);
	}

	@Override
	public Employee updateEmp(Employee e, int id) throws Exception {
		Employee e1 = empRepoo.findById(id).get();
		if(e1==null)
		{
			throw new Exception("Employee doesn not exist by id :"+id);
			
		}
		return empRepoo.save(e);
	}

	@Override
	public Employee getEmp(int id) throws ResourceNotFoundException {
		Employee e= empRepoo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Doesn't exists"));
		return empRepoo.findById(id).get();
	}

	@Override
	public Boolean deleteEmp(int id) throws ResourceNotFoundException {
		Employee e= empRepoo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Doesn't exists"));
	 return true;
	}

	@Override
	public List<Employee> getListofEmployees() {
		return empRepoo.findAll();
	}

	@Override
	public List<Employee> addListOfEmployees(List<Employee> em) {
		
		return empRepoo.saveAll(em);
	}

}
