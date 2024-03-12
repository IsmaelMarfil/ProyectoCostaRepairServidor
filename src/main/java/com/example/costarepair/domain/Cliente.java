package com.example.costarepair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
    @ToString.Exclude
    Set<Vehiculo> vehiculos = new HashSet<>();
    @OneToMany (mappedBy = "cliente")
    @JsonIgnore
    @ToString.Exclude
    Set<Cita> citas = new HashSet<>();



}
