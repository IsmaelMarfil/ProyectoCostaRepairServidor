package com.example.costarepair.exception;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(Long id) {
        super("Not found Cliente with id: " + id);
    }
}
