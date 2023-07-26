package com.ozgun.kitaplik.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book couldn't find with this id: " + id);
    }
}
