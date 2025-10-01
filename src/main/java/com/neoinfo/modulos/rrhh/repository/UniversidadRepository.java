/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neoinfo.modulos.rrhh.repository;

import com.neoinfo.modulos.rrhh.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author blackshadow
 */
public interface UniversidadRepository extends JpaRepository<Universidad, Long>, JpaSpecificationExecutor<Universidad>{
}
