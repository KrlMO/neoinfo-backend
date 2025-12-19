/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoinfo.modulos.rrhh.dto.PersonaDTO;
import com.neoinfo.modulos.rrhh.dto.PersonaFilterDTO;
import com.neoinfo.modulos.rrhh.entity.Persona;
import com.neoinfo.modulos.rrhh.service.PersonaService;
import com.neoinfo.shared.dto.ApiResponse;
import com.neoinfo.shared.dto.PaginationDTO;
import static io.swagger.v3.core.util.Json.mapper;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import jdk.jfr.Name;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("${api.base-path}/rrhh")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/create/persona")
    public ResponseEntity<ApiResponse<PersonaDTO>> createPersona(@RequestBody PersonaDTO persona) throws IOException {
        try {
            PersonaDTO creado = personaService.create(persona);
            return ResponseEntity.ok(new ApiResponse<>(true, "Persona registrada correctamente: "+ creado.getUsuario().getUsername(), creado));
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(false, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/persona")
//    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona)throws Exception{
//        //System.out.println(">>> JSON bruto: " + rawJson);
//        //ObjectMapper mapper = new ObjectMapper();
//        //Persona persona = mapper.readValue(rawJson, Persona.class);
//        System.out.println(">>> Parseado: " + persona);
//        return ResponseEntity.ok(persona);
    ////        System.out.println(">>> JSON recibido: " + persona);
////        System.out.println(">>> Recibido: " + persona.getNombres() + " - " + persona.getApellidos());
////        return persona;
//        //return personaService.crearPersona(personaDTO);
//    }

    
    

    @PostMapping("/filter")
    public ResponseEntity<ApiResponse<PaginationDTO<PersonaDTO>>> filterPeople(@RequestBody PersonaFilterDTO filter) {
        return personaService.filterPeople(filter);
    }
    

}
