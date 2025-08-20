/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import com.neoinfo.modulos.gestioncurso.entity.Ciclo;
import com.neoinfo.modulos.gestioncurso.entity.Curso;
import com.neoinfo.modulos.gestioncurso.entity.Evaluacion;
import com.neoinfo.modulos.rrhh.entity.Universidad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Ciclo cicloAplicable;

    @ManyToMany
    @JoinTable(
            name = "cupon_universidad",
            joinColumns = @JoinColumn(name = "cupon_id"),
            inverseJoinColumns = @JoinColumn(name = "universidad_id")
    )
    private List<Universidad> universidadesAplicables = new ArrayList<>();

    public Cupon(Long idCupon, String codigo, Boolean descuentoPorcentual, double descuentoMonto, LocalDate fechaCreacion, LocalDate fechaExpiracion, double montoMinimo, Ciclo cicloAplicable) {
        this.idCupon = idCupon;
        this.codigo = codigo;
        this.descuentoPorcentual = descuentoPorcentual;
        this.descuentoMonto = descuentoMonto;
        this.fechaCreacion = fechaCreacion;
        this.fechaExpiracion = fechaExpiracion;
        this.montoMinimo = montoMinimo;
        this.cicloAplicable = cicloAplicable;
    }

    public Long getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Long idCupon) {
        this.idCupon = idCupon;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getDescuentoPorcentual() {
        return descuentoPorcentual;
    }

    public void setDescuentoPorcentual(Boolean descuentoPorcentual) {
        this.descuentoPorcentual = descuentoPorcentual;
    }

    public double getDescuentoMonto() {
        return descuentoMonto;
    }

    public void setDescuentoMonto(double descuentoMonto) {
        this.descuentoMonto = descuentoMonto;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public List<Curso> getCursosAplicables() {
        return cursosAplicables;
    }

    public void setCursosAplicables(List<Curso> cursosAplicables) {
        this.cursosAplicables = cursosAplicables;
    }

    public List<Evaluacion> getEvaluacionesAplicables() {
        return evaluacionesAplicables;
    }

    public void setEvaluacionesAplicables(List<Evaluacion> evaluacionesAplicables) {
        this.evaluacionesAplicables = evaluacionesAplicables;
    }

    public double getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public Ciclo getCicloAplicable() {
        return cicloAplicable;
    }

    public void setCicloAplicable(Ciclo cicloAplicable) {
        this.cicloAplicable = cicloAplicable;
    }

    public List<Universidad> getUniversidadesAplicables() {
        return universidadesAplicables;
    }

    public void setUniversidadesAplicables(List<Universidad> universidadesAplicables) {
        this.universidadesAplicables = universidadesAplicables;
    }
    
    
    

}
