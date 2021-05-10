package com.GroupProject.VideoApp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Video implements Comparable<Video>{

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

    @ElementCollection
    @CollectionTable(name="video_comments", joinColumns = @JoinColumn(name="video_id"))
    @Column(name = "comment")
    List<Comments> comments;

    public void addCommentToList(Comments comment) {
        this.comments.add(comment);
    }

    public void incrementDislikeCount(){
        this.dislikeCount++;
    }

    public void decrementDislikeCount(){
        this.dislikeCount--;
    }

    public void incrementLikeCount(){
        this.likeCount++;
    }

    public void decrementLikeCount(){
        this.likeCount--;
    }

    public void incrementViewCount() {this.viewCount++;}


    @Override
    public int compareTo(Video o) {
        if(this.getVideoId() - o.getVideoId() == 0){
            return 0;
        }
        else if(this.getVideoId() - o.getVideoId() > 0){
            return 1;
        }
        else{
            return -1;
        }
    }
}
