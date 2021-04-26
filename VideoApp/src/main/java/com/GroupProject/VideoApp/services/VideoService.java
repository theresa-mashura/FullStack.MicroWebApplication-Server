package com.GroupProject.VideoApp.services;

import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VideoService {

    private VideoRepository repository;

    @Autowired
    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Video> getAll(){
        return repository.findAll();
    }

    // orElse(null) explantion:
    // https://stackoverflow.com/questions/44101061/missing-crudrepositoryfindone-method
    public Video getOne(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    public Video add(Video video){
        return repository.save(video);
    }

    public Video update(@PathVariable Long id, @RequestBody Video video){
        Video temp = repository.findById(id).orElse(null);
        temp.setTitle(video.getTitle());
        temp.setUserId(video.getUserId());
        temp.setLengthOfVideo(video.getLengthOfVideo());
        temp.setViewCount(video.getViewCount());
        temp.setDescription(video.getDescription());
        temp.setVideoPostedDate(video.getVideoPostedDate());
        temp.setLikeCount(video.getLikeCount());
        temp.setDislikeCount(video.getDislikeCount());
        return repository.save(temp);
    }

    public Boolean remove(@PathVariable Long id){
        repository.deleteById(id);
        return true;
    }

    public Boolean removeList(List<Video> videoList){
        repository.deleteAll(videoList);
        return true;
    }

}
