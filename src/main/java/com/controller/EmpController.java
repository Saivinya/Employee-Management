package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.exceptions.ResourceNotFoundException;
import com.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@GetMapping(path = "/getEmp/{id}")
	public ResponseEntity<Employee> getUser( @PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		Employee e = empService.getEmp(id);
		return ResponseEntity.ok(e);
	}
	
	@PostMapping(path = "/addEmp")
	public ResponseEntity<Employee> addUser(@Valid @RequestBody Employee e) throws Exception
	{
		Employee e1 = empService.addEmp(e);
		return ResponseEntity.ok(e1);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Employee> updateUser(@PathVariable(value = "id") int id, @RequestBody Employee e) throws Exception
	{
		Employee e1 = empService.updateEmp(e,id);
		return ResponseEntity.ok(e1);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) throws ResourceNotFoundException
	{
		Boolean s = empService.deleteEmp(id);
		return ResponseEntity.ok(s);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
