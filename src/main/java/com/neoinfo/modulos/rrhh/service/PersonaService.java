/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.service;

import com.neoinfo.modulos.auth.dto.RolDTO;
import com.neoinfo.modulos.auth.dto.UsuarioDTO;
import com.neoinfo.modulos.auth.entity.Rol;
import com.neoinfo.modulos.auth.entity.Usuario;
import com.neoinfo.modulos.auth.mapper.UsuarioMapper;
import com.neoinfo.modulos.auth.repository.RolRepository;
import com.neoinfo.modulos.auth.repository.UsuarioRepository;
import com.neoinfo.modulos.rrhh.dto.PersonaDTO;
import com.neoinfo.modulos.rrhh.dto.PersonaFilterDTO;
import com.neoinfo.modulos.rrhh.dto.UniversidadDTO;
import com.neoinfo.modulos.rrhh.entity.Persona;
import com.neoinfo.modulos.rrhh.entity.Universidad;
import com.neoinfo.modulos.rrhh.exception.PersonaAlreadyExistsException;
import com.neoinfo.modulos.rrhh.mapper.PersonaMapper;
import com.neoinfo.modulos.rrhh.repository.PersonaRepository;
import com.neoinfo.modulos.rrhh.repository.UniversidadRepository;
import com.neoinfo.modulos.rrhh.specification.PersonaSpecification;
import com.neoinfo.shared.dto.ApiResponse;
import com.neoinfo.shared.dto.PaginationDTO;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final UniversidadRepository universidadRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolRepository rolRepository;

    @Autowired
    private PersonaMapper personaMapper;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public PersonaService(PersonaRepository personaRepository,
            UniversidadRepository universidadRepository,
            PasswordEncoder passwordEncoder, RolRepository rolRepository) {
        this.personaRepository = personaRepository;
        this.universidadRepository = universidadRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolRepository = rolRepository;
    }

    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Transactional
    public PersonaDTO create(PersonaDTO nuevo) {
        try {
            if (personaRepository.existsByDni(nuevo.getDni())) {
                throw new PersonaAlreadyExistsException("El DNI ya está registrado");
            }

            if (personaRepository.existsByEmail(nuevo.getEmail())) {
                throw new PersonaAlreadyExistsException("El email ya está registrado");
            }

            Persona persona = personaMapper.toEntity(nuevo);
            persona = personaRepository.save(persona);

            return personaMapper.toDTO(persona);
        } catch (PersonaAlreadyExistsException e) {
            return null;
        }

    }

    @Transactional
    public PersonaDTO read(Long id) {
        try {
            Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
            if (persona == null) {
                return null;
            }
            return personaMapper.toDTO(persona);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public PersonaDTO update(PersonaDTO actualizado) {
        try {
            Persona existente = personaRepository.findById(actualizado.getId())
                    .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
            existente.setNombres(actualizado.getName());
            existente.setApellidos(actualizado.getLastName());
            existente.setEmail(actualizado.getEmail());
            existente.setDni(actualizado.getDni());
            existente.setTelefono(actualizado.getPhoneNumber());
            existente.setFechaNacimiento(actualizado.getBirthDate());

            if (actualizado.getUniversidad() != null && actualizado.getUniversidad().getId() != null) {
                Universidad universidad = universidadRepository.findById(actualizado.getUniversidad().getId())
                        .orElseThrow(() -> new RuntimeException("Universidad no encontrada"));
                existente.setUniversidad(universidad);
            } else {
                existente.setUniversidad(null);
            }

            if (actualizado.getUsuario() != null) {
                Usuario usuarioExistente = existente.getUsuario();

                if (usuarioExistente == null) {
                    usuarioExistente = usuarioMapper.toEntity(actualizado.getUsuario());
                    usuarioExistente.setPersona(existente);
                    existente.setUsuario(usuarioExistente);
                } else {

                    usuarioExistente.setUsername(actualizado.getUsuario().getUsername());

                    if (actualizado.getUsuario().getPassword() != null
                            && !actualizado.getUsuario().getPassword().isBlank()) {
                        usuarioExistente.setPassword(passwordEncoder.encode(actualizado.getUsuario().getPassword()));
                    }

                    usuarioExistente.getRoles().clear();
                    if (actualizado.getUsuario().getRoles() != null) {
                        for (RolDTO rolDTO : actualizado.getUsuario().getRoles()) {
                            Rol rol = rolRepository.findById(rolDTO.getId())
                                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
                            usuarioExistente.getRoles().add(rol);
                        }
                    }
                }
            }
            existente = personaRepository.save(existente);
            return personaMapper.toDTO(existente);

        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public boolean hardDelete(Long id) {
        try {
            Persona persona = personaRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Persona no encotrada"));
            personaRepository.delete(persona);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ResponseEntity<ApiResponse<PaginationDTO<PersonaDTO>>> filterPeople(PersonaFilterDTO filter) {
        var pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Page<Persona> page = personaRepository.findAll(PersonaSpecification.withFiler(filter), pageable);

        Page<PersonaDTO> dtoPage = page.map(p -> {
            return personaMapper.toDTO(p);
        });

        PaginationDTO<PersonaDTO> dataResponse = new PaginationDTO<>();
        dataResponse.setItems(dtoPage.getContent());
        dataResponse.setTotalItems(dtoPage.getTotalElements());
        dataResponse.setTotalPages(dtoPage.getTotalPages());
        dataResponse.setCurrentPage(dtoPage.getNumber());
        dataResponse.setSize(dtoPage.getSize());

        String message = dtoPage.isEmpty()
                ? "No se encontraron personas con los filtros dados"
                : "Listado de personas";

        return ResponseEntity.ok(
                new ApiResponse<>(true, message, dataResponse)
        );
    }

}
