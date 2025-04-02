
package com.mycompany.proyecto;

/**
 *
 * @author MegaByte
 */
public class Cliente {
     // Atributos encapsulados
    private String nombre;
    private String dni;
    private int edad;
    private double saldo;
    
    private int numerosOrdenes[];

    // Constructor
    public Cliente(String nombre, String dni, int edad, double saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.saldo = saldo;
        
        this.numerosOrdenes = new int[4];
    }

    // Métodos getter y setter para acceder a los atributos encapsulados

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos de la clase

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Saldo: " + saldo);
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se ha depositado " + cantidad + ". Saldo actual: " + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que 0.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Se ha retirado " + cantidad + ". Saldo restante: " + saldo);
        } else if (cantidad > saldo) {
            System.out.println("No tienes suficiente saldo para realizar este retiro.");
        } else {
            System.out.println("La cantidad a retirar debe ser mayor que 0.");
        }
    }
}
