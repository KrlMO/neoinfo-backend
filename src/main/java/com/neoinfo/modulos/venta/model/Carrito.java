/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.model;

/**
 *
 * @author calmo
 */
public class Carrito {
    private String idCarrito;
    private int idCliente;
    private Compra compra;
    private double montoFinal;

    public Carrito(String idCarrito, int idCliente, Compra compra, double montoFinal) {
        this.idCarrito = idCarrito;
        this.idCliente = idCliente;
        this.compra = compra;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }
    
    
}
