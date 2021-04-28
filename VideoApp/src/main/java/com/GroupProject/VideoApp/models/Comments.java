package com.GroupProject.VideoApp.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
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

}
