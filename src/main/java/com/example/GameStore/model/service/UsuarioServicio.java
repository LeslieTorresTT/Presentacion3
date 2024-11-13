package com.example.GameStore.model.service;

import com.example.GameStore.model.dto.UsuarioRegistroDTO;
import com.example.GameStore.model.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    //listar todos los usuarios
    public List<Usuario> listarUsuarios();

    public void cambiarRolUsuario(Long id);
    /*
    public Usuario guardarUsuario(Usuario usuario);

    public Usuario obtenerUsuarioPorId(Long id);

    public Usuario actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(Long id);
    */
}
