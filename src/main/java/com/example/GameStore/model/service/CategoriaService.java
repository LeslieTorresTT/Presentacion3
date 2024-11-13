package com.example.GameStore.model.service;

import com.example.GameStore.model.entity.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> listarTodasLasCategorias();

    public Categoria guardarCategoria(Categoria categoria);

    public Categoria obtenerCategoriaPorId(Long id);

    public Categoria actualizarCategoria(Categoria persona);

    public void eliminarCategoria(Long id);

}
