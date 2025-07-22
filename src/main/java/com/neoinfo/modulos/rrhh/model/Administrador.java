/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.model;

import java.util.Date;

/**
 *
 * @author calmo
 */
public class Administrador extends Persona{
    private Boolean estado;

    public Administrador(Boolean estado, int id, String nombres, String apellidos, String telefono, Date fechaNacimiento, String DNI) {
        super(id, nombres, apellidos, telefono, fechaNacimiento, DNI);
        this.estado = estado;
    }
    
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
