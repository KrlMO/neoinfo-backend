/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.model;

import com.neoinfo.modulos.gestioncurso.model.Curso;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author calmo
 */
public class Instructor extends Persona{
    private ArrayList<Curso> cursosAsignados;

    public Instructor(ArrayList<Curso> cursosAsignados, int id, String nombres, String apellidos, String telefono, Date fechaNacimiento, String DNI) {
        super(id, nombres, apellidos, telefono, fechaNacimiento, DNI);
        this.cursosAsignados = cursosAsignados;
    }

    public ArrayList<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCursosAsignados(ArrayList<Curso> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }
    
    
}
