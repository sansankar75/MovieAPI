package com.example.moviebooking.exception;

public class ActorAlreadyExistsException extends RuntimeException {

    public ActorAlreadyExistsException(String message){
        super(message);
    }
}
