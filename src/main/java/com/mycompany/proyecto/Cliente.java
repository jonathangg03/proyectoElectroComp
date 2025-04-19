
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author MegaByte
 */
public class Cliente {
    String id;
    String nombreCompleto;
    String telefono;
    String correo;
    TipoCliente tipoCliente;

    public Cliente(String id, String nombreCompleto, String telefono, String correo, TipoCliente tipoCliente) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public void mostrarTodosLosDatos() {
        System.out.println(
                "ID: " + getId()+ "\n"
                + "Nombre completo: " + getNombreCompleto() + "\n"
                + "Telefono: " + getTelefono()+ "\n"
                + "Correo: " + getCorreo() + "\n"
                + "Tipo cliente: " + getTipoCliente());

        System.out.println(" ");
    }

}
