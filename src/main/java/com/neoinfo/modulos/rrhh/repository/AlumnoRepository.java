/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neoinfo.modulos.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neoinfo.modulos.rrhh.entity.Alumno;
import org.springframework.stereotype.Repository;
/**
 *
 * @author carlosmo
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
    
}
