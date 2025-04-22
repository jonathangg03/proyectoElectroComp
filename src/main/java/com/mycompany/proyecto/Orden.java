package com.mycompany.proyecto;

import java.time.LocalDate;

public class Orden {

    private static int contadorOrdenNum = 3000;

    private int ordenNum;
    private String idCliente;
    private String codTecnico;
    private TipoDispositivo dispositivo;
    private String marca;
    private String modelo;
    private String problema;
    private EstadoOrden estado;
    private String fechaIngreso;
    private String solucion;
    private double costo;
    private double precio;

    //Constructor 
    public Orden(String idCliente, String codTecnico, TipoDispositivo dispositivo, String marca, String modelo, String problema, EstadoOrden estado) {
        this.ordenNum = contadorOrdenNum;
        contadorOrdenNum++;

        this.idCliente = idCliente;
        this.codTecnico = codTecnico;
        this.dispositivo = dispositivo;
        this.marca = marca;
        this.modelo = modelo;
        this.problema = problema;
        this.estado = estado;
        this.fechaIngreso = LocalDate.now().toString();
    }

    //getter and setter
    public int getContadorOrdenNum() {
        return contadorOrdenNum;
    }

    public void setContadorOrdenNum(int contadorOrdenNum) {
        this.contadorOrdenNum = contadorOrdenNum;
    }

    public int getOrdenNum() {
        return ordenNum;
    }

    public void setOrdenNum(int ordenNum) {
        this.ordenNum = ordenNum;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(String codTecnico) {
        this.codTecnico = codTecnico;
    }

    public TipoDispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(TipoDispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Metodos
    public void mostrarDatosOrden() {
        System.out.println("Número de orden: " + ordenNum);
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Código Técnico: " + codTecnico);
        System.out.println("Tipo de dispositivo: " + dispositivo);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Problema: " + problema);
        System.out.println("Estado: " + estado);
        System.out.println("Fecha de ingreso: " + fechaIngreso);
        if (estado == EstadoOrden.Reparada || estado == EstadoOrden.Devolucion) {
            System.out.println("Solución: " + solucion);
            System.out.println("Costo: ₡" + costo);
            System.out.println("Precio final: ₡" + precio);
    }

    }

}
