package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name="nombreCate", nullable = false, length = 50)
    private String nombreCate;

    @Column(name="descripcion", nullable = false, length = 255)
    private String descripcion;

    public Categoria(String nombreCate, String descripcion) {
        this.nombreCate = nombreCate;
        this.descripcion = descripcion;
    }

}
