package com.example.costarepair.service;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.domain.Vehiculo;
import com.example.costarepair.exception.ClienteNotFoundException;
import com.example.costarepair.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> all(int pagina, int tamano){
        Pageable paginado = PageRequest.of(pagina, tamano, Sort.by("id").ascending());
        Page<Cliente> pageAll = this.clienteRepository.findAll(paginado);

        Map<String,Object> response = new HashMap<>();

        response.put("clientes", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());
        return response;

    }

}
