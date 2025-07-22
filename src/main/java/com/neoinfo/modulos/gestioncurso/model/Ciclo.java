/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Ciclo {
    private int id_ciclo;
    private String descripcion;
    private Date fecha_incio;
    private Date fecha_fin;
    /**
     * @return the id_ciclo
     */
    public int getId_ciclo() {
        return id_ciclo;
    }

    /**
     * @param id_ciclo the id_ciclo to set
     */
    public void setId_ciclo(int id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha_incio
     */
    public Date getFecha_incio() {
        return fecha_incio;
    }

    /**
     * @param fecha_incio the fecha_incio to set
     */
    public void setFecha_incio(Date fecha_incio) {
        this.fecha_incio = fecha_incio;
    }

    /**
     * @return the fecha_fin
     */
    public Date getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

}
