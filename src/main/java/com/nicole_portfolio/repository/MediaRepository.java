package com.nicole_portfolio.repository;

import com.nicole_portfolio.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findByActiveAndProjectId(String active, Long projectFk);

}