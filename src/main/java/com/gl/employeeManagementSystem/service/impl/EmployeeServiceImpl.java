package com.gl.employeeManagementSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.repository.EmployeeRepository;
import com.gl.employeeManagementSystem.service.EmployeeService;


@Service
public  class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepository;
	


	@Override
	public List<Employee> findAll() {
		
		List<Employee> emp = empRepository.findAll();
		return emp;
		
	}

/*	@Override
	public void save() {

	}

	@Override
	public void delete() {

	}

	@Override
	public void update() {

	}*/

	@Override
	public Employee findById(int id) {
		return empRepository.findById(id).get();
	}

 	@Override
	public void save(Employee emp) {
		empRepository.save(emp);
		
	}

	@Override
	public void delete(int id) {
		empRepository.deleteById(id);
		
	}

	@Override
	public void update(Employee emp) {
		Employee employee=	empRepository.findById(emp.getId()).get();
		employee.setEmail(emp.getEmail());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		empRepository.save(emp);
		
	}
	
}
