package com.example.costarepair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    @OneToMany (mappedBy = "cliente")
    @JsonIgnore
    Set<Vehiculo> vehiculos = new HashSet<>();
    @OneToMany (mappedBy = "cliente")
    @JsonIgnore
    Set<Cita> citas = new HashSet<>();



}
