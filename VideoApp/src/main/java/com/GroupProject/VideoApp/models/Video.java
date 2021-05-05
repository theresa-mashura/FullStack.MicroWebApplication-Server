package com.GroupProject.VideoApp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    String category;
    //List<Tag> videoTags;


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
