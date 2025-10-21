package com.Splitwise.Splitwise.web;


import com.Splitwise.Splitwise.persistence.entity.User;
import com.Splitwise.Splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAll(){
        return this.userService.getUsers();
    }


}
