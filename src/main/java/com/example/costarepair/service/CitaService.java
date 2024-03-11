package com.example.costarepair.service;

import com.example.costarepair.domain.Cita;
import com.example.costarepair.domain.Cliente;
import com.example.costarepair.exception.CitaNotFoundException;
import com.example.costarepair.exception.ClienteNotFoundException;
import com.example.costarepair.repository.CitaRepository;
import com.example.costarepair.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CitaService {
    private final CitaRepository citaRepository;
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }
    public List<Cita> all() {
        return citaRepository.findAll();
    }
    public Cita save (Cita cita){
        return this.citaRepository.save(cita);
    }

    public Cita one(Long id) {
        return this.citaRepository.findById(id)
                .orElseThrow(() -> new CitaNotFoundException(id));
    }

    public Cita replace(Long id, Cita cita) {

        return this.citaRepository.findById(id).map( p -> (id.equals(cita.getId())  ?
                        this.citaRepository.save(cita) : null))
                .orElseThrow(() -> new CitaNotFoundException(id));

    }

    public void delete(Long id) {
        this.citaRepository.findById(id).map(p -> {this.citaRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new CitaNotFoundException(id));
    }
}
