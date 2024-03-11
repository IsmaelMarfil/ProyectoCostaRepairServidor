package com.example.costarepair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private long id;
    private Date fecha;
    private Time hora;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="idCliente", foreignKey = @ForeignKey(name = "FK_CITA_CLIENTE"))
    private Cliente cliente;
}
