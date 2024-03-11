package com.example.costarepair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private long id;

    private String matricula;
    private String marca;
    private String modelo;
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Cliente cliente;

}
