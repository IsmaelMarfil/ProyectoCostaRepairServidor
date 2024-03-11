package com.example.costarepair.repository;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
