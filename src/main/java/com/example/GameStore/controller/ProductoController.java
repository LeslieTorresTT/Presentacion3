package com.example.GameStore.controller;

import com.example.GameStore.model.entity.Categoria;
import com.example.GameStore.model.entity.Producto;
import com.example.GameStore.model.entity.Promocion;
import com.example.GameStore.model.repository.CategoriaRepository;
import com.example.GameStore.model.repository.ProductoRepository;
import com.example.GameStore.model.repository.PromocionRepository;
import com.example.GameStore.model.service.files.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productorepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioProducto(Model modelo){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        List<Promocion> listaPromociones = promocionRepository.findAll();

        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("categorias", listaCategorias);
        modelo.addAttribute("promociones", listaPromociones);

        return "/Productos/producto_formulario";
    }
    //---------------------------------------------------------------------------
    @PostMapping("/productos/guardar")
    public String guardarPorducto(@ModelAttribute Producto producto, @RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            // Agrega un mensaje de error
            return "redirect:/productos?error=Selecciona un archivo";
        }
        try {
            //Guarda el archivo y obtiene la ruta
            String rutafile = uploadFileService.saveFile(file);
            //Establece la ruta del archivo en el producto
            producto.setRutaArchivo(rutafile);
            //Guarda el producto
            productorepository.save(producto);
        } catch (IOException e) {
            throw new RuntimeException("Error al subir el archivo o el producto", e);
        }
        return "redirect:/productos";
    }
    //---------------------------------------------------------------------------
    @GetMapping("/productos")
    public String listarProductos(Model modelo){
        List<Producto> listaProductos = productorepository.findAll();
        modelo.addAttribute("productos", listaProductos);
        return "/Productos/productos";
    }
}
