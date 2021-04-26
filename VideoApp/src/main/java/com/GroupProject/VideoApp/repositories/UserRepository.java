package com.GroupProject.VideoApp.repositories;

import com.GroupProject.VideoApp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
