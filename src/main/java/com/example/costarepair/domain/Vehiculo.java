package com.example.costarepair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JoinColumn(name="idCliente", foreignKey = @ForeignKey(name = "FK_VEHICULO_CLIENTE"))
    private Cliente cliente;

}
