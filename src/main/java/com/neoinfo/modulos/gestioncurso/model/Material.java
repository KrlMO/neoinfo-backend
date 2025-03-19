/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.gestioncurso.model;

/**
 *
 * @author ASUS
 */
public class Material {
    
    enum TipoMaterial{
        VIDEO, DOCUMENTO, REUNION
    }
    
    private int id_material;
    private String url; // lo colocamos como string?
    private TipoMaterial tipo;
}
