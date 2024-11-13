package com.example.GameStore.model.repository;

import com.example.GameStore.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
//JpaRepository implementa todos los métodos findALL, save, getById...
//El primer parámetro (Usuario) representa la entidad con la que el repositorio trabajará, en este caso, la entidad Usuario.
//El segundo parámetro (Long) representa el tipo de la clave primaria (ID) de la entidad Usuario. para findById, deleteById, getById
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

    //para actualizar el rol a NORMAL
    @Transactional
    @Modifying
    @Query("UPDATE Rol r SET r.nombreRol = 'ROLE_ADMIN' WHERE r IN (SELECT ur FROM Usuario u JOIN u.roles ur WHERE u.id = :id)")
    public void actualizarRol(Long id);




}
