package com.example.GameStore.controller;

import com.example.GameStore.model.entity.Promocion;
import com.example.GameStore.model.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

@Controller
public class PromocionController {

    @Autowired
    private PromocionService service;
    //listar
    @GetMapping({"/promociones"})
    public String listarPromocion(Model model) {
        model.addAttribute("promociones", service.listarTodasLasPromociones());
        return "/Promociones/promociones";
    }
    //formulario para crear
    @GetMapping({"/promocion/nuevo", "/promocion/crear"})
    public String mostrarFormularioDePromociones(Model modelo) {
        Promocion promocion = new Promocion();
        modelo.addAttribute("promocion", promocion);
        return "/Promociones/crear_promocion";
    }
    //guardar
    @PostMapping("/promociones")
    public String guardarPromocion(@ModelAttribute("promocion") Promocion promocion) {

        service.guardarPromocion(promocion);
        return "redirect:/promociones";
    }
    //formulario para editar
    @GetMapping("/promocion/editar/{idPromocion}")
    public String mostrarFormularioDePromocion(@PathVariable Long idPromocion, Model model) {
        model.addAttribute("promocion", service.obtenerPromocionPorId(idPromocion));
        return "/Promociones/editar_promocion";
    }
    //formulario para guardar edición
    @PostMapping("/promocion/{idPromocion}")
    public String actualizarPromocion(@PathVariable Long idPromocion, @ModelAttribute("promocion") Promocion promocion, Model modelo) {
        Promocion promocionExistente = service.obtenerPromocionPorId(idPromocion);

        promocionExistente.setNombreProm(promocion.getNombreProm());
        promocionExistente.setDescripcion(promocion.getDescripcion());
        promocionExistente.setFechaInc(promocion.getFechaInc());
        promocionExistente.setFechaFin(promocion.getFechaFin());
        promocionExistente.setProcentajeDesc(promocion.getProcentajeDesc());

        service.actualizarPromocion(promocionExistente);
        return "redirect:/promociones";
    }//funcion para eliminar
    @GetMapping("/promocion/eliminar/{id}")
    public String eliminarPromocion(@PathVariable Long id) {
        service.eliminarPromocion(id);
        return "redirect:/promociones";
    }
}
