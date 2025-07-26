/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import com.neoinfo.modulos.gestioncurso.entity.Evaluacion;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;

/**
 *
 * @author calmo
 */
@Entity
public class PackEvaluacion extends Pack{
    @ManyToMany
    private ArrayList<Evaluacion> evaluaciones;

    public PackEvaluacion(Long idPack, String Nombre, double precio) {
        super(idPack, Nombre, precio);
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
}
