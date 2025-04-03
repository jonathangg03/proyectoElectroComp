/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author dgarcia
 */
public class Usuario {
    private static int contadorCodigoAdministrador = 201;
    private static int contadorCodigoTecnico = 101;
    private String codigo;
    private String nombreCompleto;
    private String nombreDeUsuario;
    private String clave;
    private Estado estado;
    private Rol rol;
    
    public Usuario(String nombreCompleto, String nombreDeUsuario, String clave, Rol rol ) {
        this.nombreCompleto = nombreCompleto;
        this.nombreDeUsuario = nombreDeUsuario;
        this.clave = clave;
        this.estado = Estado.ACTIVO;
        this.rol = rol;
                if (this.rol.equals(Rol.ADMINISTRADOR)) {
            this.codigo = "A-" + contadorCodigoAdministrador;
            contadorCodigoAdministrador++;
        } else {
            this.codigo = "T-" + contadorCodigoTecnico;
            contadorCodigoTecnico++;
        }
    }
    
    //Getter / setter
    public String getCodigo(){
        return codigo;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    public void setNombreUusario(String nombreDeUsuario){
        this.nombreDeUsuario = nombreDeUsuario;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave){
        this.clave = clave;
    }
    public Estado getEstado(){
        return estado;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }
    public Rol getRol(){
        return rol;
    }
    public void setRol(Rol rol){
        this.rol = rol;
    }
    
    // Metodos
    public void mostrarUsuario(){
        String claveOculta = "";
        for (int i = 0; i < clave.length(); i++) {
            claveOculta += "*";
            
        }
        JOptionPane.showMessageDialog(null,
                "CODIGO: " + codigo
                +"\nNOMBRE COMPLETO: " + nombreCompleto
                +"\nNOMBRE DE USUARIO: " + nombreDeUsuario
                +"\nCLAVE:" + claveOculta
                +"\nESTADO: " + Estado.ACTIVO
                + "\nROL: " + rol);
    }
    
    public void agregarUsuario(String nuevoNombreCompleto, String nuevoNombreDeUsuario, String nuevaClave){
        this.nombreCompleto = nuevoNombreCompleto;
        this.nombreDeUsuario = nuevoNombreDeUsuario;
        this.clave = nuevaClave;
        this.estado = Estado.ACTIVO;
        this.rol = Rol.ADMINISTRADOR;
        System.out.println("Nuevo usuario agregado con éxito.");
    }
    
    public void mostrarTodosLosDatos() {
        int longitudClave = this.clave.length();
        String claveAMostrar = "";
        
        for(int i = 0; i < longitudClave; i++) {
            claveAMostrar += "*";
        }
        
        System.out.println(
                "Nombre completo: " + getNombreCompleto() + "\n"
                + "Código: " + getCodigo() + "\n"
                + "Nombre de usuario: " + getNombreDeUsuario() + "\n"
                + "Clave: " + claveAMostrar + "\n"
                + "Estado: " + getEstado() + "\n"
                + "Rol: " + getRol());
       
        System.out.println(" ");
    }
}
