/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.model;

import com.neoinfo.modulos.gestioncurso.model.Curso;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author calmo
 */
public class Venta {
    private int idVenta;
    private Date fechaCompra;
    private double montoTotal;
    private int idCliente;
    private ArrayList<Curso> cursosSeleccionados;

    public Venta(int idVenta, Date fechaCompra, double montoTotal, int idCliente, ArrayList<Curso> cursosSeleccionados) {
        this.idVenta = idVenta;
        this.fechaCompra = fechaCompra;
        this.montoTotal = montoTotal;
        this.idCliente = idCliente;
        this.cursosSeleccionados = cursosSeleccionados;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Curso> getCursosSeleccionados() {
        return cursosSeleccionados;
    }

    public void setCursosSeleccionados(ArrayList<Curso> cursosSeleccionados) {
        this.cursosSeleccionados = cursosSeleccionados;
    }

    
    
}
