package com.example.GameStore.model.service;

import java.util.List;
import com.example.GameStore.model.entity.Promocion;
import com.example.GameStore.model.repository.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionRepository repository;

    @Override
    public List<Promocion> listarTodasLasPromociones() {
        return repository.findAll();
    }

    @Override
    public Promocion guardarPromocion(Promocion promocion) {
        return repository.save(promocion);
    }

    @Override
    public Promocion obtenerPromocionPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Promocion actualizarPromocion(Promocion promocion) {
        return repository.save(promocion);
    }

    @Override
    public void eliminarPromocion(Long id) {
        repository.deleteById(id);
    }


}
