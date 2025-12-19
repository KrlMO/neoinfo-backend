/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.auth.mapper;

import com.neoinfo.modulos.auth.dto.RolDTO;
import com.neoinfo.modulos.auth.dto.UsuarioDTO;
import com.neoinfo.modulos.auth.entity.Usuario;
import com.neoinfo.modulos.auth.repository.RolRepository;
import com.neoinfo.modulos.auth.repository.UsuarioRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author blackshadow
 */
@Component
public class UsuarioMapper {

    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioDTO toDTO(Usuario entity) {
        if (entity == null) {
            return null;
        }

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setRoles(entity.getRoles().stream().map(rol
                -> new RolDTO(rol.getId(),
                        rol.getNombre())).collect(Collectors.toList()));
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }

        Usuario entity;

        if (dto.getId() != null && dto.getId() > 0) {
            entity = usuarioRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        } else {
            entity = new Usuario();
        }

        entity.setUsername(dto.getUsername());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        entity.setActivo(dto.isActive());

        if (dto.getRoles() != null) {
            entity.setRoles(dto.getRoles().stream()
                    .map(rolDTO -> rolRepository.findById(rolDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"))
                    ).collect(Collectors.toList()));
        }

        return entity;
    }

}
