/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
@Entity
public class Evaluacion {
    @Id
    private Long id_evaluacion;
    private String codigo;
    private double precio;
    private boolean cuentaAsesoria;
    private ArrayList<Material>materiales;

        
}
