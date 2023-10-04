package com.gl.employeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;
import java.util.*;
@Controller
@RequestMapping("/employees")
public class EmployeeController {


	@Autowired
 	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployee(Model model)
	{
		List<Employee> emp = employeeService.findAll();
		model.addAttribute("employees", emp);
		employeeService.findById(1);
		return "employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee emp = new Employee();
		model.addAttribute("Employee", emp);
		return("/employee/employee-form");
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		employeeService.save(emp);
		return("redirect:/employee/employee-list");
	}
	@PostMapping("/showFormForupdate")
	public String showFormFoUpdate(@RequestParam("EmpId") int id, Model model) {
		Employee emp= employeeService.findById(id);
		model.addAttribute("Employee",emp);
		return("/employee/employee-form");
	}
	@PostMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("Empid") int id) {
		employeeService.delete(id);
		return("redirect:/employee/employee-list");
	}
}
