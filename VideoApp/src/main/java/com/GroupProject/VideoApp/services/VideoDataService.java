package com.GroupProject.VideoApp.services;

import com.GroupProject.VideoApp.models.Comments;
import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.repositories.VideoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoDataService {

    private VideoDataRepository repository;

    @Autowired
    public VideoDataService(VideoDataRepository repository) {
        this.repository = repository;
    }

    public Iterable<Video> getAll(){
        return repository.findAll();
    }

    public List<Video> getAllNews() {
        List<Video> allNewsVideos = new ArrayList<>();
        for(Video v : repository.findAll()){
            if(v.getCategory().equals("News")){
                allNewsVideos.add(v);
            }
        }
        return allNewsVideos;
    }

    public List<Video> getAllSports() {
        List<Video> allSportsVideos = new ArrayList<>();
        for(Video v : repository.findAll()){
            if(v.getCategory().equals("Sports")){
                allSportsVideos.add(v);
            }
        }
        return allSportsVideos;
    }

    public List<Video> getAllEntertaniment() {
        List<Video> allEntertainmentVideos = new ArrayList<>();
        for(Video v : repository.findAll()){
            if(v.getCategory().equals("Entertainment")){
                allEntertainmentVideos.add(v);
            }
        }
        return allEntertainmentVideos;
    }

    public List<Video> getAllMusic() {
        List<Video> allMusicVideos = new ArrayList<>();
        for(Video v : repository.findAll()){
            if(v.getCategory().equals("Music")){
                allMusicVideos.add(v);
            }
        }
        return allMusicVideos;
    }

    public List<Video> getAllTraveling() {
        List<Video> allTravelingVideos = new ArrayList<>();
        for(Video v : repository.findAll()){
            if(v.getCategory().equals("Traveling")){
                allTravelingVideos.add(v);
            }
        }
        return allTravelingVideos;
    }

    public List<Video> getAllFitness() {
        List<Video> allFitnessVideos = new ArrayList<>();
        for(Video v : repository.findAll()){
            if(v.getCategory().equals("Fitness")){
                allFitnessVideos.add(v);
            }
        }
        return allFitnessVideos;
    }

    public List<Video> getAllVideoGames() {
        List<Video> allVideoGamesVideos = new ArrayList<>();
        for(Video v : repository.findAll()){
            if(v.getCategory().equals("Video Games")){
                allVideoGamesVideos.add(v);
            }
        }
        return allVideoGamesVideos;
    }



    // orElse(null) explanation:
    // https://stackoverflow.com/questions/44101061/missing-crudrepositoryfindone-method
    public Video getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Video add(Video video){
        return repository.save(video);
    }

    public Video update(Long id, Video video){
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

    public Video updateTitleDescriptionCategory(Long id, Video video) {
        Video temp = repository.findById(id).orElse(null);
        temp.setTitle(video.getTitle());
        temp.setDescription(video.getDescription());
        temp.setCategory(video.getCategory());
        temp.setVideoPostedDate(video.getVideoPostedDate());
        return this.repository.save(temp);
    }

    public Boolean remove(Long id){
        repository.deleteById(id);
        return true;
    }

    public Boolean removeList(List<Video> videoList){
        repository.deleteAll(videoList);
        return true;
    }

    public Video incrementLikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.incrementLikeCount();
        return repository.save(temp);
    }

    public Video decrementLikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.decrementLikeCount();
        return repository.save(temp);
    }

    public Video incrementDislikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.incrementDislikeCount();
        return repository.save(temp);
    }

    public Video decrementDislikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.decrementDislikeCount();
        return repository.save(temp);
    }

    public Video addComment(Long id, Comments comment){
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.addCommentToList(comment);
        return repository.save(temp);
    }

    public Video incrementViewCount(Long id){
        Video temp = repository.findById(id).orElse(null);
        temp.incrementViewCount();
        return repository.save(temp);
    }

}
