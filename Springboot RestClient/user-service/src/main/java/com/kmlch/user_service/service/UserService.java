package com.kmlch.user_service.service;


import com.kmlch.user_service.dtos.UserRequest;
import com.kmlch.user_service.dtos.UserResponse;
import com.kmlch.user_service.entity.User;
import com.kmlch.user_service.exception.ResourceNotFoundException;
import com.kmlch.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {//inyeccion de dependencia
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());

       return userRepository.save(user);
    }
    public  User getUserById(Long id){
       return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with id " + id + " not found"));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void updateUserById(long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with id " + id + " not found"));
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        userRepository.save(user);
    }
}
