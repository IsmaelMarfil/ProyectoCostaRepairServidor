package com.example.costarepair.repository;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    public List<Vehiculo> findByMarcaContainingIgnoreCase(String marca);
    public List<Vehiculo> findByMarcaContainingIgnoreCaseOrderByModeloAsc(String marca);
    public List<Vehiculo> findByMarcaContainingIgnoreCaseOrderByModeloDesc(String marca);

}
