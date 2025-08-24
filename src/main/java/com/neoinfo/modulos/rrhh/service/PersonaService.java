/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.service;

import com.neoinfo.modulos.auth.repository.UsuarioRepository;
import com.neoinfo.modulos.rrhh.dto.PersonaDTO;
import com.neoinfo.modulos.rrhh.dto.PersonaFilterDTO;
import com.neoinfo.modulos.rrhh.entity.Persona;
import com.neoinfo.modulos.rrhh.repository.PersonaRepository;
import com.neoinfo.modulos.rrhh.specification.PersonaSpecification;
import com.neoinfo.shared.dto.ApiResponse;
import com.neoinfo.shared.dto.PaginationDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

//    public PersonaDTO crearPersona(PersonaDTO dto){
//        System.out.println(">>> Service" );
//        Persona persona = new Persona();
//        persona.setNombres(dto.getNombres());
//        persona.setApellidos(dto.getApellidos());
//        
//        
//        Persona saved = personaRepository.save(persona);
//        PersonaDTO response = new PersonaDTO();
//        response.setId(saved.getId());
//        response.setNombres(saved.getNombres());
//        response.setApellidos(saved.getApellidos());
//        
//        return response;
//    }
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    public ResponseEntity<ApiResponse<PaginationDTO<PersonaDTO>>> filterPeople(PersonaFilterDTO filter) {
        var pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Page<Persona> page = personaRepository.findAll(PersonaSpecification.withFiler(filter), pageable);

        Page<PersonaDTO> dtoPage = page.map(p -> {
            PersonaDTO dto = new PersonaDTO();
            dto.setId(p.getId());
            dto.setUsername(p.getUsuario().getUsername());
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
