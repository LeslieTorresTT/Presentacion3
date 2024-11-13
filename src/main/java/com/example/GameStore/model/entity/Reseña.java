package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Table(name="reseña")
public class Reseña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReseña;

    @Column(name = "comentario", nullable = false, length = 50)
    private String comentario;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @Column(name="fechaReseña", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") // Se asegura del formato de entrada
    private Date fechaReseña; // Cambiado de String a Date

    @ManyToOne
    @JoinColumn(name="id", nullable = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = true)
    private Producto producto;

    public Reseña(String comentario, Integer calificacion, Date fechaReseña, Usuario usuario, Producto producto) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fechaReseña = fechaReseña;
        this.usuario = usuario;
        this.producto = producto;
    }
}
