/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author dgarcia
 */
public class Usuario {
    private String nombreCompleto;
    private String nombreDeUsuario;
    private String clave;
    
    public Usuario(String nombreCompleto, String nombreDeUsuario, String clave) {
        this.nombreCompleto = nombreCompleto;
        this.nombreDeUsuario = nombreDeUsuario;
        this.clave = clave;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    
    public String getClave() {
        return clave;
    }
}
