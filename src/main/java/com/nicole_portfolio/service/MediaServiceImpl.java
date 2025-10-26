package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Media;
import com.nicole_portfolio.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService{
    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public List<Media> getMedia(Long projectFk) {
        if (projectFk != null) {
            return mediaRepository.findByActiveAndProjectId("Y", projectFk);
        }
        return null;
    }

    @Override
    public Media createMedia(Media media) {
        media.setActive("Y");
        return mediaRepository.save(media);
    }

    @Override
    public Media updateMedia(Long id, Media mediaDetails) {
        return mediaRepository.findById(id).map(media -> {
            media.setType(mediaDetails.getType());
            media.setUrl(mediaDetails.getUrl());
            media.setDescription(mediaDetails.getDescription());
            media.setActive(mediaDetails.getActive());
            return mediaRepository.save(media);
        }).orElse(null);
    }

    @Override
    public void deleteMedia(Long id) {
        mediaRepository.findById(id).ifPresent(media -> {
            media.setActive("N");
            mediaRepository.save(media);
        });
    }
}
