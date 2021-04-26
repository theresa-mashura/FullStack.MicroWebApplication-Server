package com.GroupProject.VideoApp.models;


import javax.persistence.*;
import java.util.Date;

@Entity
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

    public Long getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLengthOfVideo() {
        return lengthOfVideo;
    }

    public void setLengthOfVideo(Integer lengthOfVideo) {
        this.lengthOfVideo = lengthOfVideo;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public void incrementViewCount(){
        this.viewCount++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getVideoPostedDate() {
        return videoPostedDate;
    }

    public void setVideoPostedDate(Date videoPostedDate) {
        this.videoPostedDate = videoPostedDate;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public void incrementLikeCount(){
        this.likeCount++;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
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
