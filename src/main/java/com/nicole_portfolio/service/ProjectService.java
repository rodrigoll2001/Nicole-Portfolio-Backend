package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Projects;

import java.util.List;

public interface ProjectService {
    List<Projects> getProjects(String titleFilter);
    Projects getProjectById(Long id);
    Projects createProject(Projects project);
    Projects updateProject(Long id, Projects projectDetails);
    void deleteProject(Long id);
}

