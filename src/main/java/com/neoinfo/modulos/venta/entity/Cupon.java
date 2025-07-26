/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import com.neoinfo.modulos.gestioncurso.entity.Curso;
import com.neoinfo.modulos.gestioncurso.entity.Evaluacion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author calmo
 */
@Entity
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCupon;
    private String codigo;
    private Boolean descuentoPorcentual;
    private double descuentoMonto;
    private LocalDate fechaCreacion;
    private LocalDate fechaExpiracion;
    @ManyToMany
    @JoinTable(
            name = "cupon_curso",
            joinColumns = @JoinColumn(name = "cupon_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursosAplicables = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "cupon_evaluacion",
            joinColumns = @JoinColumn(name = "cupon_id"),
            inverseJoinColumns = @JoinColumn(name = "evaluacion_id")
    )
    private List<Evaluacion> evaluacionesAplicables = new ArrayList<>();
    private double montoMinimo;

}
