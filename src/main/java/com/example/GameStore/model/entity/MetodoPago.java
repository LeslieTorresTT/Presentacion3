package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Table(name="metodopago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodoPago;

    @Column(name="TipoPago", nullable = false, length = 45)
    private String tipopago;

    @Column(name="descripcion", nullable = false, length = 250)
    private String descripcion;

    public MetodoPago(String TipoPago, String descripcion) {
        this.tipopago = TipoPago;
        this.descripcion = descripcion;
    }
}

