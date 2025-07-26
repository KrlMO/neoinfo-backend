/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private int[] cursosIds;
    private double montoMinimo;

    public Cupon(Long idCupon, String codigo, Boolean descuentoPorcentual, double descuentoMonto, LocalDate fechaCreacion, LocalDate fechaExpiracion, int[] cursosIds, double montoMinimo) {
        this.idCupon = idCupon;
        this.codigo = codigo;
        this.descuentoPorcentual = descuentoPorcentual;
        this.descuentoMonto = descuentoMonto;
        this.fechaCreacion = fechaCreacion;
        this.fechaExpiracion = fechaExpiracion;
        this.cursosIds = cursosIds;
        this.montoMinimo = montoMinimo;
    }

    public Cupon() {
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

    public int[] getCursosIds() {
        return cursosIds;
    }

    public void setCursosIds(int[] cursosIds) {
        this.cursosIds = cursosIds;
    }

    public double getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }
    
    
}
