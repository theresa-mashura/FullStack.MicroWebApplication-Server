package com.GroupProject.VideoApp.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    String text;
    Date datePosted;


    public Comments() {

    }

    public Comments( Long id, String text, Date datePosted){
        this.id = id;
        this.text = text;
        this.datePosted = datePosted;
    }

    public Long getId () {
        return id;
    }

    public void SetId() {
        this.id = id;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }



    public String submitComment () {
        return null;

    }

    public String likeComment() {
        return null;

    }

    public String dislikeComment () {
        return null;

    }





}
