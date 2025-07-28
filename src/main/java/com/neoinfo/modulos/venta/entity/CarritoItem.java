/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.neoinfo.modulos.venta.entity;

import com.neoinfo.modulos.gestioncurso.entity.Curso;
import com.neoinfo.modulos.gestioncurso.entity.Evaluacion;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author calmo
 */
@Entity
public class CarritoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Carrito carrito;
    @ManyToOne
    private Evaluacion evaluacion;
    @ManyToOne
    private Curso curso;
    private double precio;
    @ManyToOne
    private Cupon cuponAplicado;
    @Enumerated(EnumType.STRING)
    private EnumTipoContenido tipoConetenido;

    public CarritoItem() {
    }

    public CarritoItem(Long id, Carrito carrito, Evaluacion evaluacion, Curso curso, double precio, Cupon cuponAplicado, EnumTipoContenido tipoConetenido) {
        this.id = id;
        this.carrito = carrito;
        this.evaluacion = evaluacion;
        this.curso = curso;
        this.precio = precio;
        this.cuponAplicado = cuponAplicado;
        this.tipoConetenido = tipoConetenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Cupon getCuponAplicado() {
        return cuponAplicado;
    }

    public void setCuponAplicado(Cupon cuponAplicado) {
        this.cuponAplicado = cuponAplicado;
    }

    public EnumTipoContenido getTipoConetenido() {
        return tipoConetenido;
    }

    public void setTipoConetenido(EnumTipoContenido tipoConetenido) {
        this.tipoConetenido = tipoConetenido;
    }
    
    
}
