package com.example.GameStore.controller;

import com.example.GameStore.model.dto.UsuarioRegistroDTO;
import com.example.GameStore.model.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    @Autowired
    @Lazy
    private UsuarioServicio usuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        LocalDate fechaCreacion = LocalDate.now();
        // Convertir LocalDate a java.sql.Date
        registroDTO.setFechaInscripcion(java.sql.Date.valueOf(fechaCreacion));
        registroDTO.setEstado("1");
        //registroDTO.setRol("Cliente");
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }



}
