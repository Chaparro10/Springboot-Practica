package com.kmlch.email_service.external_service;


import com.kmlch.email_service.models.UserRequest;
import com.kmlch.email_service.models.UserResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserService {

 private  final RestClient restClient;

    public UserService(RestClient.Builder builder) {
        this.restClient = builder
                        .baseUrl("http://localhost:9000/api/v1")
                        .build();
    }


    public List<UserResponse> getAllUser(){
         List allUsers = restClient.get().
                uri("/users").
                retrieve().
                body(new ParameterizedTypeReference<List<UserResponse>>(){});

        return  allUsers;
    }

    public UserResponse getUserById(long id){
        UserResponse userResponse= restClient.get().
                uri("/users/{id}",id).
                retrieve().
                body(UserResponse.class);

        return  userResponse;
    }


    public UserResponse createUser(UserRequest userRequest){
       UserResponse userResponse =  restClient.post().
               uri("/users").
               body(userRequest).
               retrieve().
               body(UserResponse.class);

       return userResponse;
    }


    public ResponseEntity<Void> deleteUser(long id){
       ResponseEntity<Void> res= restClient
                .delete()
                .uri("/users/{id}",id)
                .retrieve()
                .toBodilessEntity();
        System.out.println("RESPONSE:: " + res);

        return res;

    }

    public ResponseEntity<Void> updateUser(long id, UserRequest userRequest){
        ResponseEntity<Void> res= restClient
                .patch()
                .uri("/users/{id}",id)
                .body(userRequest)
                .retrieve()
                .toBodilessEntity();
        System.out.println("RESPONSE:: " + res);
        return res;
    }




}
