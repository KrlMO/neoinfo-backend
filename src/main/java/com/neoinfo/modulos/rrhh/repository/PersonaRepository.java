/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.repository;

import com.neoinfo.modulos.rrhh.dto.PersonaDTO;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neoinfo.modulos.rrhh.entity.Persona;
import com.neoinfo.shared.dto.ApiResponse;
import com.neoinfo.shared.dto.PaginationDTO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author calmo
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona> {
   
}
