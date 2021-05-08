package com.GroupProject.VideoApp.controllers;

import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.services.VideoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // get 1 video by id
    @GetMapping("/video/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id){
        return new ResponseEntity<>(service.getOne(id),HttpStatus.OK);
    }

    // get all videos
    @GetMapping("/video")
    public ResponseEntity<Iterable<Video>> getAllVideos(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    // get all News videos
    @GetMapping("/video/news")
    public ResponseEntity<List<Video>> getAllNewsVideos(){
        return new ResponseEntity<>(service.getAllNews(),HttpStatus.OK);
    }

    // get all Sports videos
    @GetMapping("/video/sports")
    public ResponseEntity<List<Video>> getAllSportsVideos(){
        return new ResponseEntity<>(service.getAllSports(),HttpStatus.OK);
    }

    // get all Entertainment videos
    @GetMapping("/video/entertainment")
    public ResponseEntity<List<Video>> getAllEntertainmentVideos(){
        return new ResponseEntity<>(service.getAllEntertaniment(),HttpStatus.OK);
    }

    // get all Music videos
    @GetMapping("/video/music")
    public ResponseEntity<List<Video>> getAllMusicVideos(){
        return new ResponseEntity<>(service.getAllMusic(),HttpStatus.OK);
    }

    // get all Traveling videos
    @GetMapping("/video/traveling")
    public ResponseEntity<List<Video>> getAllTravelingVideos(){
        return new ResponseEntity<>(service.getAllTraveling(),HttpStatus.OK);
    }

    // get all Fitness videos
    @GetMapping("/video/fitness")
    public ResponseEntity<List<Video>> getAllFitnessVideos(){
        return new ResponseEntity<>(service.getAllFitness(),HttpStatus.OK);
    }

    // get all Video Games videos
    @GetMapping("/video/videogames")
    public ResponseEntity<List<Video>> getAllVideoGamesVideos(){
        return new ResponseEntity<>(service.getAllVideoGames(),HttpStatus.OK);
    }

    @DeleteMapping("/video/delete/{id}")
    public ResponseEntity<Boolean> deleteVideo(@PathVariable Long id){
        return new ResponseEntity<>(service.remove(id),HttpStatus.OK);
    }

}
