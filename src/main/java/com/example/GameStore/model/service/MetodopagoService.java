package com.example.GameStore.model.service;


import com.example.GameStore.model.entity.MetodoPago;

import java.util.List;
public interface MetodopagoService {

    public List<MetodoPago> listarMetodopago();

    public MetodoPago guardarMetodopago(MetodoPago metodoPago);

    public MetodoPago obtenerMetodopagoPorId(Long id);

    public MetodoPago actualizarMetodopago(MetodoPago metodoPago);

    public void eliminarMetodopago(Long id);

}
