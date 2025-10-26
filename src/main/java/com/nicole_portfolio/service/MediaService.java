package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Media;
import com.nicole_portfolio.entity.Projects;

import java.util.List;

public interface MediaService {
    List<Media> getMedia(Long projectFk);
    Media createMedia(Media media);
    Media updateMedia(Long id, Media mediaDetails);
    void deleteMedia(Long id);
}
