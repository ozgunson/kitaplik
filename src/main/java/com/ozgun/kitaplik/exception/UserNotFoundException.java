package com.ozgun.kitaplik.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User couldn't find with this id: " + id);
    }
}
