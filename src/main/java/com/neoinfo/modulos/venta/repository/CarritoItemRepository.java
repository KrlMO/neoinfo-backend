/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neoinfo.modulos.venta.repository;

import com.neoinfo.modulos.venta.entity.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carlosmo
 */
public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long>{
    
}
