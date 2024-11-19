package com.example.GameStore.controller;

import com.example.GameStore.model.entity.Categoria;
import com.example.GameStore.model.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    /*-------*/
    @Autowired
    private CategoriaService service;

    @GetMapping({"/categorias"})
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", service.listarTodasLasCategorias());
        return "Categorias/categorias";
    }
    @GetMapping({"/categoria/nuevo", "/categoria/crear"})
    public String mostrarFormularioDeCategorias(Model modelo) {
        Categoria categoria = new Categoria();
        modelo.addAttribute("categoria", categoria);
        return "Categorias/crear_categoria";
    }

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        service.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categoria/editar/{idCategoria}")
    public String mostrarFormularioDe(@PathVariable Long idCategoria, Model model) {
        model.addAttribute("categoria", service.obtenerCategoriaPorId(idCategoria));
        return "Categorias/editar_categoria";
    }
    @PostMapping("/categorias/{idCategoria}")
    public String actualizarCategoria(@PathVariable Long idCategoria, @ModelAttribute("categoria") Categoria categoria, Model modelo) {
        Categoria categoriaExistente = service.obtenerCategoriaPorId(idCategoria);
        categoriaExistente.setNombreCate(categoria.getNombreCate());
        categoriaExistente.setDescripcion(categoria.getDescripcion());

        service.actualizarCategoria(categoriaExistente);
        return "redirect:/categorias";
    }
    @GetMapping("/categoria/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        service.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}
