/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.repository;

import com.neoinfo.modulos.gestioncurso.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carlosmo
 */
public interface MaterialRepository extends JpaRepository<Material, Long>{
    
}
