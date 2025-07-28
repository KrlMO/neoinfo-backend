/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.venta.entity;

import com.neoinfo.modulos.gestioncurso.entity.Curso;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;

/**
 *
 * @author calmo
 */
@Entity
public class PackCurso extends Pack{
    @ManyToMany
    private ArrayList<Curso> cursos;

    public PackCurso(ArrayList<Curso> cursos, Long idPack, String Nombre, double precio) {
        super(idPack, Nombre, precio);
        this.cursos = cursos;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }    
}
