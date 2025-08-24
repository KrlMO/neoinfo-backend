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
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import jdk.jfr.Name;
import org.apache.catalina.mapper.Mapper;
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

    @PostMapping("/persona")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona, HttpServletRequest request) throws IOException {
        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(">>> RAW JSON: " + body);
        System.out.println(">>> Parseado: " + persona);
        return ResponseEntity.ok(persona);
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

    
    @GetMapping("/personas")
    public List<Persona> listar() {
        return personaService.listarPersonas();
    }

    @PostMapping("/filter")
    public ResponseEntity<ApiResponse<PaginationDTO<PersonaDTO>>> filterPeople(@RequestBody PersonaFilterDTO filter) {
        return personaService.filterPeople(filter);
    }
}
