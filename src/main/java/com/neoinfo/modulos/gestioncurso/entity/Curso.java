/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.entity;

import com.neoinfo.modulos.rrhh.entity.Instructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    private String codigo;
    private String nombre;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
    
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    
    @ManyToOne
    @JoinColumn(name = "ciclo_id")
    private Ciclo ciclo;

    public Curso() {
    }

    public Curso(Long idCurso, String codigo, String nombre, Instructor instructor, Ciclo ciclo) {
        this.idCurso = idCurso;
        this.codigo = codigo;
        this.nombre = nombre;
        this.instructor = instructor;
        this.ciclo = ciclo;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
    
}
