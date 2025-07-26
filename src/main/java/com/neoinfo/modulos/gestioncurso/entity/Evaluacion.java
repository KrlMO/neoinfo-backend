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
    
}
