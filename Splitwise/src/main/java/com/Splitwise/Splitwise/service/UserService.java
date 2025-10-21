package com.Splitwise.Splitwise.service;


import com.Splitwise.Splitwise.persistence.entity.User;
import com.Splitwise.Splitwise.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
