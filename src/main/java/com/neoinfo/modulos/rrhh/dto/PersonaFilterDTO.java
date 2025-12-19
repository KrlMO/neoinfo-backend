/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.neoinfo.modulos.rrhh.dto;

import java.time.LocalDate;

/**
 *
 * @author calmo
 */
public class PersonaFilterDTO {
    private String username;
    private String name;
    private String email;
    private String dni;
    private String role;
    private LocalDate registerDateFrom;
    private LocalDate registerDateTo;
    private int page = 0;
    private int size = 10;

    public PersonaFilterDTO() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PersonaFilterDTO(String username, String name, String email, String dni, String role, LocalDate registerDateFrom, LocalDate registerDateTo) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.dni = dni;
        this.role = role;
        this.registerDateFrom = registerDateFrom;
        this.registerDateTo = registerDateTo;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getRegisterDateFrom() {
        return registerDateFrom;
    }

    public void setRegisterDateFrom(LocalDate registerDateFrom) {
        this.registerDateFrom = registerDateFrom;
    }

    public LocalDate getRegisterDateTo() {
        return registerDateTo;
    }

    public void setRegisterDateTo(LocalDate registerDateTo) {
        this.registerDateTo = registerDateTo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    

    
}
