package com.example.costarepair.exception;

public class CitaNotFoundException extends RuntimeException {
    public CitaNotFoundException(Long id) {
        super("Not found Cita with id: " + id);
    }
}
