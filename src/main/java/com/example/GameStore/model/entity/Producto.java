package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "nombreProd", nullable = false, length = 50)
    private String nombreProd;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Column(name="genero", nullable = false, length = 50)
    private String genero;

    @Column(name="descripcion", length = 250)
    private String descripcion;

    @Column(name="estado", length = 1)
    private String estado;

    @Column(name="rutaImagen")
    private String rutaImagen;

    @Column(name="rutaArchivo")
    private String rutaArchivo;

    @ManyToOne
    @JoinColumn(name="id_categoria", nullable = true)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="id_promocion", nullable = true)
    private Promocion promocion;

    public Producto(String nombreProd, Float precio, String genero, String descripcion, String estado, String rutaImagen, String rutaArchivo, Categoria categoria, Promocion promocion) {
        this.nombreProd = nombreProd;
        this.precio = precio;
        this.genero = genero;
        this.descripcion = descripcion;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
        this.rutaArchivo = rutaArchivo;
        this.categoria = categoria;
        this.promocion = promocion;
    }

}
