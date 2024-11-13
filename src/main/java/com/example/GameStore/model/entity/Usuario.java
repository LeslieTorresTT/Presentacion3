package com.example.GameStore.model.entity;

import java.util.Collection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name="apPaterno", nullable = false, length = 50)
    private String apPaterno;

    @Column(name="apMaterno", nullable = false, length = 50)
    private String apMaterno;

    @Column(name="telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name="direccion", length = 100)
    private String direccion;

    @Column(name="dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name="fechaInscripcion", nullable = false)
    private Date fechaInscripcion; // Cambiado de String a Date

    @Column(name="sexo", nullable = false, length = 1)
    private String sexo; //"M": Masculino, "F": Femenino

    @Column(name="estado", length = 1)
    private String estado; //"0": Inactivo, "1": Activo

    //@Column(name="email", nullable = false, length = 70, unique = true)
    private String email;

    //@Column(name="password", nullable = false, length = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_roles",
            //referencia a usuario_id de la tabla intermedia con el id de la entidad presente "Usuario"
            joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
            //referencia a rol_id de la tabla intermedia con el id de la entidad "Rol"
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
            )
    private Collection<Rol> roles;
    /*
    @Column(name="rol", length = 30)
    private String rol;*/

    //constructor sin Id
    public Usuario(String nombre, String apPaterno, String apMaterno, String telefono, String direccion, String dni, Date fechaInscripcion, String sexo, String estado, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaInscripcion = fechaInscripcion;
        this.sexo = sexo;
        this.estado = estado;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
