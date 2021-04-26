package com.GroupProject.VideoApp.services;


import com.GroupProject.VideoApp.models.User;
import com.GroupProject.VideoApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User add(User user){return userRepository.save(user);}

    public User update(Long id, User user){
        User change = userRepository.findById(id).orElse(null);
        change.setEmail(user.getEmail());
        change.setUserName(user.getUserName());
        change.setPassword(user.getPassword());
        change.setFirstName(user.getFirstName());
        change.setLastName(user.getLastName());
        return userRepository.save(change);
    }

    public Boolean remove(Long id){
        userRepository.deleteById(id);
        return true;
    }
}
