package com.nicole_portfolio.repository;

import com.nicole_portfolio.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

    List<Projects> findByActiveAndTitleContainingIgnoreCase(String active, String title);

    List<Projects> findByActive(String active);


}