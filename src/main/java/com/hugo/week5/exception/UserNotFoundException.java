package com.hugo.week5.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String email) {
        super(String.format("We could not find a user whit the given email: %s", email));
    }
}
