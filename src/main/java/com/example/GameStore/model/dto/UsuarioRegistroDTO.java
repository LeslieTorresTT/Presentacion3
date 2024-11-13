package com.example.GameStore.model.dto;

import com.example.GameStore.model.entity.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data // Genera getters, setters, toString, equals, hashCode *---LOMBOK
@NoArgsConstructor // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefono;
    private String direccion;
    private String dni;
    private Date fechaInscripcion;
    private String sexo; //"M": Masculino, "F": Femenino
    private String estado; //"0": Inactivo, "1": Activo
    private String email;
    private String password;

    public UsuarioRegistroDTO(String nombre, String apPaterno, String apMaterno, String telefono, String direccion, String dni, Date fechaInscripcion, String sexo, String estado, String email, String password) {
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
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }
}
