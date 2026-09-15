package com.kmlch.user_service.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
