/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.model;

import com.neoinfo.modulos.gestioncurso.model.Curso;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author calmo
 */
public class Inscripcion {
    private String idInscripcion;
    private ArrayList<Curso> cursosInscritos;
    private Date fechaInscripcion;

    public Inscripcion(String idInscripcion, ArrayList<Curso> cursosInscritos, Date fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.cursosInscritos = cursosInscritos;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(String idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public ArrayList<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(ArrayList<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    
}
