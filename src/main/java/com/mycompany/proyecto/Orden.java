package com.mycompany.proyecto;

import javax.swing.JOptionPane;

public class Orden {
    private int ordenNum;
    private int idCliente;
    private int codTecnico;
    private String dispositivo;
    private String marca;
    private String modelo;
    private String problema;
    private String estado;
    
    public Orden(int ordenNum, int idCliente, int codTecnico, String dispositivo, String marca, String modelo, String problema, String estado){
        this.ordenNum = ordenNum;
        this.idCliente = idCliente;
        this.codTecnico = codTecnico;
        this.dispositivo = dispositivo;
        this.marca = marca;
        this.modelo = modelo;
        this.problema = problema;
        this.estado = estado;
    }
    //get
    public int getOrdenNum() {
        return ordenNum;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getCodTecnico() {
        return codTecnico;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getProblema() {
        return problema;
    }

    public String getEstado() {
        return estado;
    }
    //set
    public void setOrdenNum(int ordenNum) {
        this.ordenNum = ordenNum;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setCodTecnico(int codTecnico) {
        this.codTecnico = codTecnico;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //Metodos
    public void mostrarOrden(){
        System.out.println(
                "#Orden: " + ordenNum
                + "\nCliente: " + idCliente
                + "\nDispositivo: " + dispositivo
                + "\nMarca: " + marca
                + "\nModelo: " + modelo);
    }
    public void agregarOrden(){
        //agregar
    }
}
