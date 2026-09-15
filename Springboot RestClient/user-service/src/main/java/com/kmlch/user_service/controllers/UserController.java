package com.kmlch.user_service.controllers;


import com.kmlch.user_service.dtos.UserRequest;
import com.kmlch.user_service.dtos.UserResponse;
import com.kmlch.user_service.entity.User;
import com.kmlch.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final String uri="/api/v1/users/";

    public UserController(UserService userService){ //inyeccion por constructor
        this.userService=userService;
    }

    @PostMapping("")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest){
        System.out.println("body::: " + userRequest.toString());
      User user = userService.saveUser(userRequest);
      UserResponse userResponse = new UserResponse(user.getId(),user.getName(),user.getEmail());

       return ResponseEntity.created(URI.create(uri + userResponse.id())).body(userResponse);
    }

     @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
         UserResponse userResponse = new UserResponse(user.getId(),user.getName(),user.getEmail());

         return ResponseEntity.status(HttpStatus.OK).body(userResponse);
     }

     @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){

        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }

     @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest){

        userService.updateUserById(id,userRequest);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }
}
