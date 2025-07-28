/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.neoinfo.modulos.gestioncurso.entity;

import com.neoinfo.modulos.auth.entity.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

/**
 *
 * @author calmo
 */
@Entity
public class AccesoMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Material material;
    
    private LocalDate fechaAccesoInicial;
    private LocalDate fechaLimiteAcceso;

    public AccesoMaterial() {
    }

    public AccesoMaterial(Long id, Usuario usuario, Material material, LocalDate fechaAccesoInicial, LocalDate fechaLimiteAcceso) {
        this.id = id;
        this.usuario = usuario;
        this.material = material;
        this.fechaAccesoInicial = fechaAccesoInicial;
        this.fechaLimiteAcceso = fechaLimiteAcceso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public LocalDate getFechaAccesoInicial() {
        return fechaAccesoInicial;
    }

    public void setFechaAccesoInicial(LocalDate fechaAccesoInicial) {
        this.fechaAccesoInicial = fechaAccesoInicial;
    }

    public LocalDate getFechaLimiteAcceso() {
        return fechaLimiteAcceso;
    }

    public void setFechaLimiteAcceso(LocalDate fechaLimiteAcceso) {
        this.fechaLimiteAcceso = fechaLimiteAcceso;
    }
    
    
}
