package com.example.costarepair.service;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.domain.Vehiculo;
import com.example.costarepair.exception.ClienteNotFoundException;
import com.example.costarepair.exception.VehiculoNotFoundException;
import com.example.costarepair.repository.ClienteRepository;
import com.example.costarepair.repository.VehiculoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Map<String, Object> all(int pagina, int tamano){
        Pageable paginado = PageRequest.of(pagina, tamano, Sort.by("id").ascending());
        Page<Vehiculo> pageAll = this.vehiculoRepository.findAll(paginado);

        Map<String,Object> response = new HashMap<>();

        response.put("vehiculos", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());
        return response;

    }
    public List<Vehiculo> allByQueryFiltersStream(Optional<String> buscarOpcion, Optional<String> ordenarOpcional){
        List<Vehiculo> resultado = null;
        if(buscarOpcion.isPresent()){
            resultado = vehiculoRepository.findByMarcaContainingIgnoreCase(buscarOpcion.get());        }
        if(ordenarOpcional.isPresent()){
            if(buscarOpcion.isPresent() && "asc".equalsIgnoreCase(ordenarOpcional.get())){
                resultado = vehiculoRepository.findByMarcaContainingIgnoreCaseOrderByModeloAsc(buscarOpcion.get());
            } else if (buscarOpcion.isPresent() && "desc".equalsIgnoreCase(ordenarOpcional.get())) {
                resultado = vehiculoRepository.findByMarcaContainingIgnoreCaseOrderByModeloDesc(buscarOpcion.get());
            }
        }
        return resultado;

    }
}
