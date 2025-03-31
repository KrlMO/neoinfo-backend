/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.model;

import com.neoinfo.modulos.gestioncurso.model.Curso;
import com.neoinfo.modulos.venta.model.Inscripcion;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author calmo
 */
public class Alumno extends Persona{
    private ArrayList<Curso> cursosInscritos;
    private ArrayList<Inscripcion> inscripciones;

    public Alumno(ArrayList<Curso> cursosInscritos, ArrayList<Inscripcion> inscripciones, int id, String nombres, String apellidos, String telefono, Date fechaNacimiento, String DNI) {
        super(id, nombres, apellidos, telefono, fechaNacimiento, DNI);
        this.cursosInscritos = cursosInscritos;
        this.inscripciones = inscripciones;
    }

    public ArrayList<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(ArrayList<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    
}
