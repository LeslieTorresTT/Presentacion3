package com.example.GameStore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.naming.Name;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Table(name="venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(name="fechaVenta", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") // Se asegura del formato de entrada
    private Date fechaVenta; // Cambiado de String a Date

    @Column(name = "igv", nullable = false, precision = 3, scale = 2)
    private BigDecimal igv;

    @Column(name = "totalVenta", nullable = false)
    private Float totalVenta;

    @Column(name="estado", length = 1)
    private String estado;

    //relacion de muchos a uno con la tabla usuarios
    @ManyToOne
    @JoinColumn(name="id", nullable = false)
    private Usuario usuario;

    //relacion de muchos a uno con la tabla metodo de pago
    @ManyToOne
    @JoinColumn(name="id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    //relacion de uno a muchos con la tabla detalle_venta para el acceso a datos
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //para otros casos
    //@JoinColumn(name="id_detalle_venta", nullable = false) //donde se agrega una columna mas en la tabla referenciada
    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Detalle_Venta> detalle_venta;

    public Venta(Date fechaVenta, BigDecimal igv, Float totalVenta, String estado, Usuario usuario, MetodoPago metodoPago, List<Detalle_Venta> detalle_venta) {
        this.fechaVenta = fechaVenta;
        this.igv = igv;
        this.totalVenta = totalVenta;
        this.estado = estado;
        this.usuario = usuario;
        this.metodoPago = metodoPago;
        this.detalle_venta = detalle_venta;
    }
}
