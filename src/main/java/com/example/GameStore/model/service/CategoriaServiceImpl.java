package com.example.GameStore.model.service;

import java.util.List;
import com.example.GameStore.model.entity.Categoria;
import com.example.GameStore.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listarTodasLasCategorias() {return repository.findAll();}

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        repository.deleteById(id);
    }


}
