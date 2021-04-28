package com.GroupProject.VideoApp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userId;
    String email;
    String userName;
    String password;
    String firstName;
    String lastName;



    public User() {
    }

    public User(Long userId, String email, String userName, String password, String firstName, String lastName) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
