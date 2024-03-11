package com.example.costarepair.service;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.domain.Vehiculo;
import com.example.costarepair.exception.ClienteNotFoundException;
import com.example.costarepair.exception.VehiculoNotFoundException;
import com.example.costarepair.repository.ClienteRepository;
import com.example.costarepair.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }
    public List<Vehiculo> all() {
        return vehiculoRepository.findAll();
    }
    public Vehiculo save (Vehiculo vehiculo){
        return this.vehiculoRepository.save(vehiculo);
    }

    public Vehiculo one(Long id) {
        return this.vehiculoRepository.findById(id)
                .orElseThrow(() -> new VehiculoNotFoundException(id));
    }

    public Vehiculo replace(Long id, Vehiculo vehiculo) {

        return this.vehiculoRepository.findById(id).map( p -> (id.equals(vehiculo.getId())  ?
                        this.vehiculoRepository.save(vehiculo) : null))
                .orElseThrow(() -> new VehiculoNotFoundException(id));

    }

    public void delete(Long id) {
        this.vehiculoRepository.findById(id).map(p -> {this.vehiculoRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new VehiculoNotFoundException(id));
    }
}
