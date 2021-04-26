package com.GroupProject.VideoApp.services;


import com.GroupProject.VideoApp.models.Comments;
import com.GroupProject.VideoApp.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository repository;

    public CommentsService(CommentsRepository repository) {this.repository = repository;}

    public Iterable<Comments> index() {return repository.findAll();}

    public Comments show(Long id) {return repository.findById(id).get();}

    public Comments create (Comments comment) {return repository.save(comment);}

    public Comments update(Long id, Comments newPersonData) {
        Comments originalComment = repository.findById(id).get();
        originalComment.setText(newPersonData.getText());
        originalComment.setDatePosted(newPersonData.getDatePosted());
        return repository.save(originalComment);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }





}
