package com.GroupProject.VideoApp.controllers;

import com.GroupProject.VideoApp.models.Comments;
import com.GroupProject.VideoApp.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class CommentsController {
    @Autowired
    private CommentsService service;


    public CommentsController(CommentsService service) {
        this.service = service;
    }
    @GetMapping("/comments")
    public ResponseEntity<Iterable<Comments>> getCommentList() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comments> getComment(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @PostMapping("/comments")
    public ResponseEntity<Comments> createPerson (Comments comment) {
        return new ResponseEntity<>(service.create(comment), HttpStatus.CREATED);
    }
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable Long id, Comments comment) {
        return new ResponseEntity<>(service.update(id, comment), HttpStatus.OK);
    }
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }



}
