/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author calmo
 */
public class Cupon {
    private String idCupon;
    private String codigo;
    private Boolean descuentoPorcentual;
    private double descuentoMonto;
    private Date fechaCreacion;
    private Date fechaExpiracion;
    private int[] cursosIds;
    private double montoMinimo;

    public Cupon(String idCupon, String codigo, Boolean descuentoPorcentual, double descuentoMonto, Date fechaCreacion, Date fechaExpiracion, int[] cursosIds, double montoMinimo) {
        this.idCupon = idCupon;
        this.codigo = codigo;
        this.descuentoPorcentual = descuentoPorcentual;
        this.descuentoMonto = descuentoMonto;
        this.fechaCreacion = fechaCreacion;
        this.fechaExpiracion = fechaExpiracion;
        this.cursosIds = cursosIds;
        this.montoMinimo = montoMinimo;
    }

    public String getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(String idCupon) {
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
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
