package com.example.GameStore.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestVistasControlador {

    @GetMapping("/vistaVisitante")
    public String mostrarVistaVisitante(){
        return "Hola Visitante";
    }

    @GetMapping("/accessUser")
    @PreAuthorize("hasRole('ROLE_USER')") //permitimos acceder a la dirección a los que tienen el rol de ADMIN
    public String accessUser(){
        return "Hola has accedido con el Rol de usuario o cliente";
    }

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ROLE_ADMIN')") //permitimos acceder a la dirección de los que tienen el rol d ADMIN
    public String accessAdmin(){
        return "Hola has accedido con el Rol de ADMIN";
    }

}
