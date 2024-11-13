package com.example.GameStore.controller;

import com.example.GameStore.model.entity.MetodoPago;
import com.example.GameStore.model.service.MetodopagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Api {
    @Autowired
    private MetodopagoService service;

    @GetMapping("/api/metodopagos")
    public List<MetodoPago> listarMetododepago(){
        return service.listarMetodopago();
    }

}
