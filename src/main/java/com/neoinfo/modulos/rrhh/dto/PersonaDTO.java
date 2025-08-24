/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.dto;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class PersonaDTO {
    private Long id;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String dni;
    private LocalDate registerDate;
    
    
    public PersonaDTO(){
        
    }

    public PersonaDTO(Long id, String username, String name, String email,
            String dni, LocalDate registerDate, String lastName) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.dni = dni;
        this.registerDate = registerDate;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
