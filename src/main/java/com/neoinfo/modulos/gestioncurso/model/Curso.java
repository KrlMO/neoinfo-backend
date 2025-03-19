/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Evaluacion> evaluaciones;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the evaluaciones
     */
    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    /**
     * @param evaluaciones the evaluaciones to set
     */
    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    
    
}
