/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import com.neoinfo.modulos.auth.entity.Usuario;
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
 * @author calmo
 */
@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario cliente;
    @ManyToOne
    @JoinColumn(name="venta_id")
    private Venta venta;
    
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarritoItem> items = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "cupon_id")
    private Cupon cuponGlobal;
    
    private double montoFinal;
    
    private boolean activo = true;

    public Carrito() {
    }

    public Carrito(Long idCarrito, Usuario cliente, Venta venta, Cupon cuponGlobal, double montoFinal) {
        this.idCarrito = idCarrito;
        this.cliente = cliente;
        this.venta = venta;
        this.cuponGlobal = cuponGlobal;
        this.montoFinal = montoFinal;
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<CarritoItem> getItems() {
        return items;
    }

    public void setItems(List<CarritoItem> items) {
        this.items = items;
    }

    public Cupon getCuponGlobal() {
        return cuponGlobal;
    }

    public void setCuponGlobal(Cupon cuponGlobal) {
        this.cuponGlobal = cuponGlobal;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
