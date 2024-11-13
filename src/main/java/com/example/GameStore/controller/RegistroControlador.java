package com.example.GameStore.controller;

import com.example.GameStore.model.entity.Categoria;
import com.example.GameStore.model.entity.Usuario;
import com.example.GameStore.model.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo, Authentication auth) {
        String nombreUsuario = auth.getName();
        modelo.addAttribute("usernameauth", nombreUsuario);
        return "Index";
    }

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/usuarios")
    @PreAuthorize("hasRole('ROLE_ADMIN')") //permitimos acceder a la dirección de los que tienen el rol d ADMIN
    public String verPaginaDeUsuarios(Model modelo, Authentication auth) {
        String nombreUsuario = auth.getName();
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        modelo.addAttribute("usernameauth", nombreUsuario);
        return "/Usuarios/usuarios";
    }

    @GetMapping("/usuarios/{id}")
    public String actualizarRol(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario, Model modelo){
        servicio.cambiarRolUsuario(id);
        return "redirect:/usuarios";
    }
    /*
    @GetMapping("/usuarios/deshabilitar/{idUsuario}")
    public String deshabilitarUsuario(@PathVariable Long idUsuario) {
        Usuario usuarioExistente = servicio.obtenerUsuarioPorId(idUsuario);
        if (usuarioExistente.getEstado().equals("0")){
            usuarioExistente.setEstado("1");
        } else if (usuarioExistente.getEstado().equals("1")) {
            usuarioExistente.setEstado("0");
        }
        servicio.actualizarUsuario(usuarioExistente);
        return "redirect:/usuarios";
    }
    */


}
