package com.rian.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rian.pma.dao.EmployeeRepository;
import com.rian.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {

		Employee anEmployee = new Employee();

		model.addAttribute("employee", anEmployee);

		return "new-employee";
	}

	@PostMapping("/save")
	public String createEmployee(Model model, Employee employee) {
		// save to the database using an employee CRUD repository
		empRepo.save(employee);
		
		return "redirect:/employees/new";
	}
}
