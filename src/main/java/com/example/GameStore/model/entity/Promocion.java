package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Table(name="promocion")
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocion;

    @Column(name="nombreProm", nullable = false, length = 50)
    private String nombreProm;

    @Column(name="descripcion", nullable = false, length = 250)
    private String descripcion;

    @Column(name="fechaInc", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Se asegura del formato de entrada
    private Date fechaInc; // Cambiado de String a Date

    @Column(name="fechaFin", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin; // Cambiado de String a Date

    @Column(name = "procentajeDesc", nullable = false, precision = 4, scale = 3)
    private BigDecimal procentajeDesc;

    public Promocion(String nombreProm, String descripcion, Date fechaInc, Date fechaFin, BigDecimal procentajeDesc) {
        this.nombreProm = nombreProm;
        this.descripcion = descripcion;
        this.fechaInc = fechaInc;
        this.fechaFin = fechaFin;
        this.procentajeDesc = procentajeDesc;
    }
}
