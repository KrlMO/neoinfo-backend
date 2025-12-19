/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.auth.service;

import com.neoinfo.modulos.auth.entity.Usuario;
import com.neoinfo.modulos.auth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author blackshadow
 */
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public boolean softDelete(Long id) {
        try {
            Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Usuario no encontrado"));
            usuario.setActivo(false);
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
