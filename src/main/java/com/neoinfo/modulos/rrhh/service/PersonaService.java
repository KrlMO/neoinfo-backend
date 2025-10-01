/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.service;

import com.neoinfo.modulos.auth.dto.UsuarioDTO;
import com.neoinfo.modulos.auth.entity.Rol;
import com.neoinfo.modulos.auth.entity.Usuario;
import com.neoinfo.modulos.auth.repository.RolRepository;
import com.neoinfo.modulos.auth.repository.UsuarioRepository;
import com.neoinfo.modulos.rrhh.dto.PersonaDTO;
import com.neoinfo.modulos.rrhh.dto.PersonaFilterDTO;
import com.neoinfo.modulos.rrhh.dto.UniversidadDTO;
import com.neoinfo.modulos.rrhh.entity.Persona;
import com.neoinfo.modulos.rrhh.entity.Universidad;
import com.neoinfo.modulos.rrhh.exception.PersonaAlreadyExistsException;
import com.neoinfo.modulos.rrhh.repository.PersonaRepository;
import com.neoinfo.modulos.rrhh.repository.UniversidadRepository;
import com.neoinfo.modulos.rrhh.specification.PersonaSpecification;
import com.neoinfo.shared.dto.ApiResponse;
import com.neoinfo.shared.dto.PaginationDTO;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
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

            Persona persona = new Persona(
                    nuevo.getName(),
                    nuevo.getLastName(),
                    nuevo.getPhoneNumber(),
                    nuevo.getBirthDate(),
                    nuevo.getEmail(),
                    nuevo.getDni()
            );

            if (nuevo.getUniversidad() != null && nuevo.getUniversidad().getId() != null) {
                Universidad universidad = universidadRepository.findById(nuevo.getUniversidad().getId())
                        .orElseThrow(() -> new RuntimeException("Universidad no encontrada"));
                persona.setUniversidad(universidad);
            }

            if (nuevo.getUsuario() != null) {
                Usuario usuario = new Usuario();
                usuario.setUsername(nuevo.getUsuario().getUsername());
                usuario.setPassword(passwordEncoder.encode(nuevo.getUsuario().getPassword()));
                usuario.setPersona(persona);
                
                if (nuevo.getUsuario().getRol() != null && nuevo.getUsuario().getRol().getId() != null) {
                    Rol rol = rolRepository.findById(nuevo.getUsuario().getRol().getId())
                            .orElseThrow(() -> new RuntimeException("Rol no encontrada"));    
                    usuario.getRoles().add(rol);
                }
                
                persona.setUsuario(usuario);
            }

            persona = personaRepository.save(persona);

            return mapToDTO(persona);
        } catch (Exception e) {
            return null;
        }

    }

    private PersonaDTO mapToDTO(Persona persona) {
        PersonaDTO dto = new PersonaDTO();
        dto.setId(persona.getId());
        dto.setName(persona.getNombres());
        dto.setLastName(persona.getApellidos());
        dto.setEmail(persona.getEmail());
        dto.setDni(persona.getDni());
        dto.setPhoneNumber(persona.getTelefono());
        dto.setBirthDate(persona.getFechaNacimiento());

        if (persona.getUniversidad() != null) {
            UniversidadDTO uniDTO = new UniversidadDTO();
            uniDTO.setId(persona.getUniversidad().getId());
            uniDTO.setNombre(persona.getUniversidad().getNombre());
            uniDTO.setDominio(persona.getUniversidad().getDominio());
            dto.setUniversidad(uniDTO);
        }

        if (persona.getUsuario() != null) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(persona.getUsuario().getId());
            usuarioDTO.setUsername(persona.getUsuario().getUsername());

            dto.setUsuario(usuarioDTO);
        }

        return dto;
    }

    public ResponseEntity<ApiResponse<PaginationDTO<PersonaDTO>>> filterPeople(PersonaFilterDTO filter) {
        var pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Page<Persona> page = personaRepository.findAll(PersonaSpecification.withFiler(filter), pageable);

        Page<PersonaDTO> dtoPage = page.map(p -> {
            PersonaDTO dto = new PersonaDTO();
            dto.setId(p.getId());
            dto.getUsuario().setUsername(p.getUsuario().getUsername());
            dto.setName(p.getNombres());
            dto.setLastName(p.getApellidos());
            dto.setEmail(p.getEmail());
            dto.setDni(p.getDni());
            dto.setRegisterDate(p.getUsuario().getFechaRegistro());
            return dto;
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
