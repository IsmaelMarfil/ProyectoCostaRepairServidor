package com.example.costarepair.service;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.exception.ClienteNotFoundException;
import com.example.costarepair.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente> all() {
        return clienteRepository.findAll();
    }
    public Cliente save (Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Cliente one(Long id) {
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public Cliente replace(Long id, Cliente cliente) {

        return this.clienteRepository.findById(id).map( p -> (id.equals(cliente.getId())  ?
                        this.clienteRepository.save(cliente) : null))
                .orElseThrow(() -> new ClienteNotFoundException(id));

    }

    public void delete(Long id) {
        this.clienteRepository.findById(id).map(p -> {this.clienteRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }


}
