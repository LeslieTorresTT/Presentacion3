package com.example.GameStore.controller;

import com.example.GameStore.model.entity.MetodoPago;
import com.example.GameStore.model.service.MetodopagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*@RestController*/
@Controller
public class MetodopagoController {

    @Autowired
    private MetodopagoService service;

    @GetMapping({"/metodopagos"})
    public String listarMetododepago(Model model) {
        model.addAttribute("metodopagos", service.listarMetodopago());
        return "/MetodoPago/metodopagos";
    }

    @GetMapping("/metodopagos/{id}")
    public ResponseEntity<MetodoPago> obtenerMetodopagoPorId(@PathVariable Long id){
        try {
            MetodoPago metodoPago= service.obtenerMetodopagoPorId(id);
            return new ResponseEntity<MetodoPago>(metodoPago, HttpStatus.OK);
        }catch(Exception exception) {
            return new ResponseEntity<MetodoPago>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping({"/metodopagos/nuevo", "/metodopagos/crear"})
    public String mostrarFormularioDeMetododepago(Model modelo) {
        MetodoPago metodopago = new MetodoPago();
        modelo.addAttribute("metodopago", metodopago);
        return "/MetodoPago/crear_metodopago";
    }
    @PostMapping("/metodopagos")
    public String guardarMetododepagos(@ModelAttribute("metodopago") MetodoPago metodopago) {
        service.guardarMetodopago(metodopago);
        return "redirect:/metodopagos";
    }

    @GetMapping("/metodopagos/editar/{idMetodoPago}")
    public String mostrarFormularioDeMetodopago(@PathVariable Long idMetodoPago, Model model) {
        model.addAttribute("metodopago", service.obtenerMetodopagoPorId(idMetodoPago));
        return "/MetodoPago/editar_metodopago";
    }
    @PostMapping("/metodopagos/{idMetodoPago}")
    public String actualizarMetodopago(@PathVariable Long idMetodoPago, @ModelAttribute("metodopago") MetodoPago metodoPago, Model modelo) {
        MetodoPago MetodopagoExistente = service.obtenerMetodopagoPorId(idMetodoPago);
        MetodopagoExistente.setTipopago(metodoPago.getTipopago());
        MetodopagoExistente.setDescripcion(metodoPago.getDescripcion());

        service.actualizarMetodopago(MetodopagoExistente);
        return "redirect:/metodopagos";
    }
    @GetMapping("/metodopago/eliminar/{id}")
    public String eliminarMetodopago(@PathVariable Long id) {
        service.eliminarMetodopago(id);
        return "redirect:/metodopagos";
    }


}
