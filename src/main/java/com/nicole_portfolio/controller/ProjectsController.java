package com.nicole_portfolio.controller;

import com.nicole_portfolio.entity.Projects;
import com.nicole_portfolio.repository.ProjectsRepository;
import com.nicole_portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Projects> getProjects(@RequestParam(required = false) String title) {
        return projectService.getProjects(title);
    }

    @GetMapping("/{id}")
    public Projects getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Projects createProject(@RequestBody Projects project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{id}")
    public Projects updateProject(@PathVariable Long id, @RequestBody Projects projectDetails) {
        return projectService.updateProject(id, projectDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}