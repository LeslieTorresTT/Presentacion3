package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Table(name="detalle_venta")
public class Detalle_Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @Column(name = "subTotal", nullable = false)
    private Float subTotal;

    @ManyToOne
    @JoinColumn(name="id_venta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false)
    private Producto producto;

    public Detalle_Venta(Float subTotal, Venta venta, Producto producto) {
        this.subTotal = subTotal;
        this.venta = venta;
        this.producto = producto;
    }
}
