/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.login.model;

import com.neoinfo.modulos.rrhh.model.Persona;

/**
 *
 * @author calmo
 */
public class Usuario {
    private int id;
    private String username;
    private String password;
    private Persona persona;

    public Usuario(int id, String username, String password, Persona persona) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    
}
