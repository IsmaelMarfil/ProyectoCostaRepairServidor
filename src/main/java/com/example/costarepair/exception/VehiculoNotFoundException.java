package com.example.costarepair.exception;

public class VehiculoNotFoundException extends RuntimeException {
    public VehiculoNotFoundException(Long id) {
        super("Not found Vehiculo with id: " + id);
    }
}
