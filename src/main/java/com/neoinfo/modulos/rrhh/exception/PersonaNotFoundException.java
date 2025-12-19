/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.exception;

/**
 *
 * @author blackshadow
 */
public class PersonaNotFoundException extends RuntimeException{
    public PersonaNotFoundException(String message){
        super(message);
    }
}
