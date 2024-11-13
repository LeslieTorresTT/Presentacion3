package com.example.GameStore.controller;

import com.example.GameStore.model.service.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolController {

    @Autowired
    private RolServicio servicio;

    @GetMapping({"/roles"})
    public String listarRoles(Model model) {
        model.addAttribute("roles", servicio.listarTodosLosRoles());
        return "/Roles/roles";
    }

}
