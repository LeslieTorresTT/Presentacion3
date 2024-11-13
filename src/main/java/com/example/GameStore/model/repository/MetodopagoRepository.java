package com.example.GameStore.model.repository;

import com.example.GameStore.model.entity.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodopagoRepository extends JpaRepository <MetodoPago , Long> {
}
