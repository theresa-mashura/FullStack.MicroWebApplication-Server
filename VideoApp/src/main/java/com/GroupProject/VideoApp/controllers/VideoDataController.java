package com.GroupProject.VideoApp.controllers;

import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.services.VideoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin    // host serving JS may be different from host serving the data, need to allow CORS
public class VideoDataController {

    private final VideoDataService service;

    @Autowired
    public VideoDataController(VideoDataService service) {
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


    @PutMapping("/video/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video){
        return new ResponseEntity<>(service.update(id,video),HttpStatus.OK);
    }

    @PatchMapping("/video/{id}")
    public ResponseEntity<Video> updateTitleDescCatg(@PathVariable Long id, @RequestBody Video video){
        return new ResponseEntity<>(service.updateTitleDescriptionCategory(id,video),HttpStatus.OK);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id){
        return new ResponseEntity<>(service.getOne(id),HttpStatus.OK);
    }

    @GetMapping("/video")
    public ResponseEntity<Iterable<Video>> getAllVideos(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

}
