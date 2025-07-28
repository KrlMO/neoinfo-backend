/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import com.neoinfo.modulos.auth.entity.Usuario;
import com.neoinfo.modulos.gestioncurso.entity.Curso;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author calmo
 */
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private Date fechaCompra;
    private double montoTotal;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario cliente;

    @ManyToMany
    @JoinTable(
            name = "venta_curso",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursosSeleccionados = new ArrayList<>();

    public Venta() {
    }

    public Venta(Long idVenta, Date fechaCompra, double montoTotal, Usuario cliente) {
        this.idVenta = idVenta;
        this.fechaCompra = fechaCompra;
        this.montoTotal = montoTotal;
        this.cliente = cliente;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
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

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<Curso> getCursosSeleccionados() {
        return cursosSeleccionados;
    }

    public void setCursosSeleccionados(List<Curso> cursosSeleccionados) {
        this.cursosSeleccionados = cursosSeleccionados;
    }

    
    
}
