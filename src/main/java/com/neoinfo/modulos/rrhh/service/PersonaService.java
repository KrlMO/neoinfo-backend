/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.service;

import com.neoinfo.modulos.auth.repository.UsuarioRepository;
import com.neoinfo.modulos.rrhh.dto.PersonaDTO;
import com.neoinfo.modulos.rrhh.entity.Persona;
import com.neoinfo.modulos.rrhh.repository.PersonaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class PersonaService {
    private final PersonaRepository personaRepository;
    
    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository=personaRepository;
    }
    
    public PersonaDTO crearPersona(PersonaDTO dto){
        System.out.println(">>> Service" );
        Persona persona = new Persona();
        persona.setNombres(dto.getNombres());
        persona.setApellidos(dto.getApellidos());
        
        
        Persona saved = personaRepository.save(persona);
        PersonaDTO response = new PersonaDTO();
        response.setId(saved.getId());
        response.setNombres(saved.getNombres());
        response.setApellidos(saved.getApellidos());
        
        return response;
    }
    
    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }
}
