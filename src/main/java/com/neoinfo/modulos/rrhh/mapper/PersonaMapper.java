/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.mapper;

import com.neoinfo.modulos.auth.dto.UsuarioDTO;
import com.neoinfo.modulos.auth.entity.Rol;
import com.neoinfo.modulos.auth.entity.Usuario;
import com.neoinfo.modulos.auth.mapper.UsuarioMapper;
import com.neoinfo.modulos.auth.repository.RolRepository;
import com.neoinfo.modulos.rrhh.dto.PersonaDTO;
import com.neoinfo.modulos.rrhh.dto.UniversidadDTO;
import com.neoinfo.modulos.rrhh.entity.Persona;
import com.neoinfo.modulos.rrhh.entity.Universidad;
import com.neoinfo.modulos.rrhh.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author blackshadow
 */
@Component
public class PersonaMapper {

    @Autowired
    private UniversidadRepository universidadRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public PersonaDTO toDTO(Persona entity) {
        PersonaDTO dto = new PersonaDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getNombres());
        dto.setLastName(entity.getApellidos());
        dto.setEmail(entity.getEmail());
        dto.setDni(entity.getDni());
        dto.setPhoneNumber(entity.getTelefono());
        dto.setBirthDate(entity.getFechaNacimiento());

        if (entity.getUniversidad() != null) {
            UniversidadDTO uniDTO = new UniversidadDTO();
            uniDTO.setId(entity.getUniversidad().getId());
            uniDTO.setNombre(entity.getUniversidad().getNombre());
            uniDTO.setDominio(entity.getUniversidad().getDominio());
            dto.setUniversidad(uniDTO);
        }

        if (entity.getUsuario() != null) {
            dto.setUsuario(usuarioMapper.toDTO(entity.getUsuario()));
        }

        return dto;
    }

    public Persona toEntity(PersonaDTO dto) {
        Persona entity = new Persona(
                dto.getName(),
                dto.getLastName(),
                dto.getPhoneNumber(),
                dto.getBirthDate(),
                dto.getEmail(),
                dto.getDni()
        );

        if (dto.getUniversidad() != null && dto.getUniversidad().getId() != null) {
            Universidad universidad = universidadRepository.findById(dto.getUniversidad().getId())
                    .orElseThrow(() -> new RuntimeException("Universidad no encontrada"));
            entity.setUniversidad(universidad);
        }

        if (dto.getUsuario() != null) {
            Usuario usuario = usuarioMapper.toEntity(dto.getUsuario());
            usuario.setPersona(entity);
            entity.setUsuario(usuario);
        }

        return entity;

    }
}
