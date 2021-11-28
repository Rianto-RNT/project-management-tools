package com.rian.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rian.pma.dao.ProjectRepository;
import com.rian.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;

	@GetMapping("/new")
	public String displayProjectForm(Model model) {

		Project aProject = new Project();

		model.addAttribute("project", aProject);

		return "new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRepo.save(project);
		
		// use a redirect to prevent duplicate submission
		return "redirect:/project/new";
	}
}
