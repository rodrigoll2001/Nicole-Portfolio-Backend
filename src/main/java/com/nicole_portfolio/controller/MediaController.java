package com.nicole_portfolio.controller;

import com.nicole_portfolio.entity.Media;
import com.nicole_portfolio.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping
    public List<Media> getMedia(@RequestParam Long projectFk) {
        return mediaService.getMedia(projectFk);
    }

    @PostMapping
    public Media createMedia(@RequestBody Media media) {
        return mediaService.createMedia(media);
    }

    @PutMapping("/{id}")
    public Media updateMedia(@PathVariable Long id, @RequestBody Media mediaDetails) {
        return mediaService.updateMedia(id, mediaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
    }
}
