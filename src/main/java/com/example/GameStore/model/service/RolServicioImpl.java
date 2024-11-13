package com.example.GameStore.model.service;

import com.example.GameStore.model.entity.Rol;
import com.example.GameStore.model.repository.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicioImpl implements RolServicio{

    @Autowired
    private RolRepositorio repository;

    @Override
    public List<Rol> listarTodosLosRoles() {
        return repository.findAll();
    }

}
