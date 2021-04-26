package com.GroupProject.VideoApp.controllers;

import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.services.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideoController {

    private final VideoService service;

    public VideoController(VideoService service) {
        this.service = service;
    }

//    {
//            "title": "Test Video",
//            "userId": 456,
//            "lengthOfVideo": 90,
//            "viewCount": 0,
//            "description": "This is a test video",
//            "videoPostedDate": "2021-04-26",
//            "likeCount": 0,
//            "dislikeCount": 0
//    }

    @PostMapping("/video")
    public ResponseEntity<Video> createVideo(@RequestBody Video video){
        return new ResponseEntity<>(service.add(video), HttpStatus.CREATED);
    }

    @PutMapping("/video/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video){
        return new ResponseEntity<>(service.update(id,video),HttpStatus.OK);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id){
        return new ResponseEntity<>(service.getOne(id),HttpStatus.OK);
    }

    @GetMapping("/video")
    public ResponseEntity<Iterable<Video>> getAllVideos(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/video/{id}")
    public ResponseEntity<Boolean> deleteVideo(@PathVariable Long id){
        return new ResponseEntity<>(service.remove(id),HttpStatus.OK);
    }


}
