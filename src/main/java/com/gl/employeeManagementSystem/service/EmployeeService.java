package com.gl.employeeManagementSystem.service;

import java.util.List;

import com.gl.employeeManagementSystem.entity.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {
	
	public List<Employee> findAll();

	public  Employee findById(int id);
	void save(Employee emp);
	void delete(int id);
	void update(Employee emp);
}
