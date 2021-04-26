package com.GroupProject.VideoApp.repositories;

import com.GroupProject.VideoApp.models.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video,Long> {

}
