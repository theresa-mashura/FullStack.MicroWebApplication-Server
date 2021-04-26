package com.GroupProject.VideoApp.controllers;

import com.GroupProject.VideoApp.models.User;
import com.GroupProject.VideoApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){this.userService = userService;}


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.update(id,user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.remove(id), HttpStatus.OK);
    }
}
