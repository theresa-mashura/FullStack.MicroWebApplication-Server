package com.GroupProject.VideoApp.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long videoId;

    String title;
    Long userId; // id of User who uploaded video
    Integer lengthOfVideo;
    Integer viewCount = 0;
    String description;
    Date videoPostedDate;
    Integer likeCount = 0;
    Integer dislikeCount = 0;
    //List<Tag> videoTags;


    public Video(Long videoId, String title, Long userId, Integer lengthOfVideo, Integer viewCount, String description, Date videoPostedDate, Integer likeCount, Integer dislikeCount) {
        this.videoId = videoId;
        this.title = title;
        this.userId = userId;
        this.lengthOfVideo = lengthOfVideo;
        this.viewCount = viewCount;
        this.description = description;
        this.videoPostedDate = videoPostedDate;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
    }

    public Video(){

    }


    public void incrementDislikeCount(){
        this.dislikeCount++;
    }

    public void startVideo(){
        //TO DO
    }

    public void pauseVideo(){
        //TO DO
    }

    public void autoPlayVideo(){
        //TO DO
    }

    public void addTag(){
        //TO DO
    }
}
