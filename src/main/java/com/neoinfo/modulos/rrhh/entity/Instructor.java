/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.entity;

import com.neoinfo.modulos.gestioncurso.entity.Curso;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author calmo
 */
@Entity
@Table(name = "instructor")
public class Instructor extends Persona {

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Curso> cursosAsignados = new ArrayList<Curso>();

    public Instructor() {
    }

    public Instructor(Long id, String nombres, String apellidos, String telefono, LocalDate fechaNacimiento, String DNI) {
        super(id, nombres, apellidos, telefono, fechaNacimiento, DNI);
    }
    
    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCursosAsignados(List<Curso> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }

    
}
