/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


/**
 *
 * @author calmo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPack;
    private String Nombre;
    private double precio;

    public Pack() {
    }

    public Pack(Long idPack, String Nombre, double precio) {
        this.idPack = idPack;
        this.Nombre = Nombre;
        this.precio = precio;
    }

    public Long getIdPack() {
        return idPack;
    }

    public void setIdPack(Long idPack) {
        this.idPack = idPack;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
