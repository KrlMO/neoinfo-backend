/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Evaluacion {
    
    private int id_evaluacion;
    private String codigo;
    private double precio;
    private boolean cuentaAsesoria;
    private ArrayList<Material>materiales;

    /**
     * @return the id_evaluacion
     */
    public int getId_evaluacion() {
        return id_evaluacion;
    }

    /**
     * @param id_evaluacion the id_evaluacion to set
     */
    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the cuentaAsesoria
     */
    public boolean isCuentaAsesoria() {
        return cuentaAsesoria;
    }

    /**
     * @param cuentaAsesoria the cuentaAsesoria to set
     */
    public void setCuentaAsesoria(boolean cuentaAsesoria) {
        this.cuentaAsesoria = cuentaAsesoria;
    }

    /**
     * @return the materiales
     */
    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    /**
     * @param materiales the materiales to set
     */
    public void setMateriales(ArrayList<Material> materiales) {
        this.materiales = materiales;
    }
    
}
