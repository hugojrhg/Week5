package com.hugo.week5.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String email) {
        super(String.format("Already exists a user with the email: %s", email));
    }



}
