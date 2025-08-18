/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author calmo
 */
@Entity
@Table(name = "administrador")
public class Administrador extends Persona{
    private Boolean estado;

    public Administrador(Boolean estado, Long id, String nombres, String apellidos, String telefono, LocalDate fechaNacimiento, String email, String DNI) {
        super(id, nombres, apellidos, telefono, fechaNacimiento, email, DNI);
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

        
    
}
