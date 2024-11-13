package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rol")
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long idRol
    private Long id;

    @Column(name="nombreRol", nullable = false, length = 30)
    private String nombreRol;

    @Column(name="descripcion", nullable = false, length = 255)
    private String descripcion;

    public Rol(String nombreRol, String descripcion) {
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
    }

}
