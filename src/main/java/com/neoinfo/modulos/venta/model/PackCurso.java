/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.model;

import com.neoinfo.modulos.gestioncurso.model.Curso;
import java.util.ArrayList;

/**
 *
 * @author calmo
 */
public class PackCurso {
    private ArrayList<Curso> cursos;
    private double precio;

    public PackCurso(ArrayList<Curso> cursos, double precio) {
        this.cursos = cursos;
        this.precio = precio;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
