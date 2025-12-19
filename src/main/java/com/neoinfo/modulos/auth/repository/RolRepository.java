/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neoinfo.modulos.auth.repository;

import com.neoinfo.modulos.auth.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author blackshadow
 */
public interface RolRepository extends JpaRepository<Rol, Long>{
    
}
