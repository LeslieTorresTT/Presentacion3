package com.example.GameStore.model.service;

import com.example.GameStore.model.entity.Promocion;
import java.util.List;

public interface PromocionService {

    public List<Promocion> listarTodasLasPromociones();

    public Promocion guardarPromocion(Promocion promocion);

    public Promocion obtenerPromocionPorId(Long id);

    public Promocion actualizarPromocion(Promocion promocion);

    public void eliminarPromocion(Long id);

}
