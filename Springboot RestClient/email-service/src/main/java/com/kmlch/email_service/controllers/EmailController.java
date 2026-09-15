package com.kmlch.email_service.controllers;


import com.kmlch.email_service.external_service.UserService;
import com.kmlch.email_service.models.UserRequest;
import com.kmlch.email_service.models.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {


    private  final UserService userService;

    public EmailController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{id}")
    public String sendEmailUser(@PathVariable long id){

        UserResponse userResponse = userService.getUserById(id);

        String emailTemplate ="""
           Hi %s,
           Welcome !
           Your email %s
           Is now registered.
           
           Thanks you !
           
        """.formatted(userResponse.name(),userResponse.email());


        return emailTemplate;
    }


    @GetMapping("/users")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUser();
    }
    @PostMapping("")
    public UserResponse registerUser(@RequestBody UserRequest userRequest){
       return userService.createUser(userRequest);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest){
       return userService.updateUser(id,userRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }
}
