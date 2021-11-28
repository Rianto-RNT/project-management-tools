package com.rian.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rian.pma.dao.EmployeeRepository;
import com.rian.pma.dao.ProjectRepository;
import com.rian.pma.entities.Employee;
import com.rian.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) {
		
		// Querying the database for Projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		// Querying the database for Employees
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);

		return "home";
	}
}
