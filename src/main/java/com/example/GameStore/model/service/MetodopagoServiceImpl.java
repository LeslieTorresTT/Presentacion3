package com.example.GameStore.model.service;

import com.example.GameStore.model.entity.MetodoPago;
import com.example.GameStore.model.repository.MetodopagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodopagoServiceImpl implements  MetodopagoService{
    @Autowired
    private  MetodopagoRepository repository;
    @Override
    public List<MetodoPago> listarMetodopago() {return repository.findAll();}
    @Override
    public MetodoPago guardarMetodopago(MetodoPago metodoPago) {
        return repository.save(metodoPago);
    }
    @Override
    public MetodoPago obtenerMetodopagoPorId(Long id) {
        return repository.findById(id).get();
    }
    @Override
    public MetodoPago actualizarMetodopago(MetodoPago metodoPago) {
        return repository.save(metodoPago);
    }
    @Override
    public void eliminarMetodopago(Long id) {
        repository.deleteById(id);
    }

}
