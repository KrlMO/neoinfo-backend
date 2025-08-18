/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.entity;

import com.neoinfo.modulos.gestioncurso.entity.Ciclo;
import com.neoinfo.modulos.gestioncurso.entity.Curso;
import com.neoinfo.modulos.venta.entity.Inscripcion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
@Table(name = "alumno")
public class Alumno extends Persona{
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
    
    private LocalDate fechaRegistro;
    
    @ManyToOne
    private Ciclo cicloActual;

    public Alumno(LocalDate fechaRegistro, Ciclo cicloActual, Long id, String nombres, String apellidos, String telefono, LocalDate fechaNacimiento, String email, String DNI) {
        super(id, nombres, apellidos, telefono, fechaNacimiento, email, DNI);
        this.fechaRegistro = fechaRegistro;
        this.cicloActual = cicloActual;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Ciclo getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(Ciclo cicloActual) {
        this.cicloActual = cicloActual;
    }

    
       
}
