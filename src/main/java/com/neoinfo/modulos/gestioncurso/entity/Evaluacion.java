/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.entity;

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
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evaluacion;
    private String codigo;
    private double precio;
    private boolean cuentaAsesoria;
    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Material>materiales = new ArrayList<Material>();
    @ManyToOne
    @JoinColumn(name =  "curso_id")
    private Curso curso;

    public Evaluacion() {
    }

    public Evaluacion(Long id_evaluacion, String codigo, double precio, boolean cuentaAsesoria, Curso curso) {
        this.id_evaluacion = id_evaluacion;
        this.codigo = codigo;
        this.precio = precio;
        this.cuentaAsesoria = cuentaAsesoria;
        this.curso = curso;
    }

    public Long getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(Long id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isCuentaAsesoria() {
        return cuentaAsesoria;
    }

    public void setCuentaAsesoria(boolean cuentaAsesoria) {
        this.cuentaAsesoria = cuentaAsesoria;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    
}
