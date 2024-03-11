package com.example.costarepair.repository;

import com.example.costarepair.domain.Cita;
import com.example.costarepair.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
