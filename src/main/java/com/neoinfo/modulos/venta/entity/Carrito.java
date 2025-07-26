/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

/**
 *
 * @author calmo
 */
public class Carrito {
    private String idCarrito;
    private int idCliente;
    private Venta venta;
    private double montoFinal;

    public Carrito(String idCarrito, int idCliente, Venta venta, double montoFinal) {
        this.idCarrito = idCarrito;
        this.idCliente = idCliente;
        this.venta = venta;
        this.montoFinal = montoFinal;
    }

    public String getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(String idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }
    
    
}
