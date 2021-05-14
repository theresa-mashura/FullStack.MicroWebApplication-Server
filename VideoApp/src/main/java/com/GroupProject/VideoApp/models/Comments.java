package com.GroupProject.VideoApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    String postedBy;
    String commentText;
    Date datePosted;
    String user; // auth0 username
    Long commentVideoId;
}
