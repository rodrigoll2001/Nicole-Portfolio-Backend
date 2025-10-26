package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Media;
import com.nicole_portfolio.entity.Projects;
import com.nicole_portfolio.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectsRepository projectRepository;

    @Autowired
    private MediaService mediaService;

    @Override
    public List<Projects> getProjects(String titleFilter) {
        List<Projects> projects;

        if (titleFilter != null && !titleFilter.isEmpty()) {
            projects = projectRepository.findByActiveAndTitleContainingIgnoreCase("Y", titleFilter);
        } else {
            projects = projectRepository.findByActive("Y");
        }

        for (Projects project : projects) {
            List<Media> medias = mediaService.getMedia(project.getId());
            if (medias != null && !medias.isEmpty()) {
                project.setMedias(medias);
            }
        }

        return projects;

    }

    @Override
    public Projects getProjectById(Long id) {
        Projects project = projectRepository.findById(id)
                .filter(p -> "Y".equalsIgnoreCase(p.getActive()))
                .orElse(null);

        if (project != null) {
            List<Media> medias = mediaService.getMedia(project.getId());
            if (medias != null && !medias.isEmpty()) {
                project.setMedias(medias);
            }
        }

        return project;
    }

    @Override
    public Projects createProject(Projects project) {
        project.setActive("Y");
        project.setCreationDate(new java.util.Date());

        if (project.getMedias() != null) {
            project.getMedias().forEach(media -> {
                media.setActive("Y");
                media.setProject(project); // vincula o lado "muitos" ao "um"
            });
        }

        return projectRepository.save(project);
    }

    @Override
    public Projects updateProject(Long id, Projects projectDetails) {
        return projectRepository.findById(id).map(project -> {
            project.setTitle(projectDetails.getTitle());
            project.setDescription(projectDetails.getDescription());
            project.setCategoryFk(projectDetails.getCategoryFk());
            project.setActive(projectDetails.getActive());

            // limpa e substitui as mídias antigas
            project.getMedias().clear();
            if (projectDetails.getMedias() != null) {
                projectDetails.getMedias().forEach(media -> {
                    media.setActive("Y");
                    media.setProject(project);
                    project.getMedias().add(media);
                });
            }

            return projectRepository.save(project);
        }).orElse(null);
    }


    @Override
    public void deleteProject(Long id) {
        projectRepository.findById(id).ifPresent(project -> {
            project.setActive("N");
            projectRepository.save(project);
        });
    }
}
