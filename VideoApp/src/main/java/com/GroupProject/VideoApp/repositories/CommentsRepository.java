package com.GroupProject.VideoApp.repositories;

import com.GroupProject.VideoApp.models.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {
}
