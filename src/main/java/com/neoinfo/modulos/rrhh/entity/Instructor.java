/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.entity;

import com.neoinfo.modulos.gestioncurso.entity.Curso;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author calmo
 */
@Entity
public class Instructor extends Persona{
    @OneToMany(mappedBy = "Instructor", cascade = CascadeType.ALL)
    private ArrayList<Curso> cursosAsignados;
/*
    public Instructor(ArrayList<Curso> cursosAsignados, Long id, String nombres, String apellidos, String telefono, Date fechaNacimiento, String DNI) {
        super(id, nombres, apellidos, telefono, fechaNacimiento, DNI);
        this.cursosAsignados = cursosAsignados;
    }

    public ArrayList<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCursosAsignados(ArrayList<Curso> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }
*/
}
