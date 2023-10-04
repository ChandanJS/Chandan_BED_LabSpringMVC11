package com.gl.employeeManagementSystem.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeeManagementSystem.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
