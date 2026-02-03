package com.taskmind.userservice.exception;

public class InvalidCredentialsException extends  RuntimeException{

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
