package com.example.costarepair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "cita")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    @DateTimeFormat(pattern = "hh:mm")
    private Time hora;
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Cliente cliente;
}
