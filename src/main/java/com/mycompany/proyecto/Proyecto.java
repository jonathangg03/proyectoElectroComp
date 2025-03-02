/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author MegaByte
 */
public class Proyecto {

    public static void main(String[] args) {
        Usuario usuarioA = new Usuario("Sebastian Garcia", "sgarcia03", "1234as");
        Usuario usuarioB = new Usuario("Keneth Gonzalez", "kengo20", "5678df");
        String usuarioIngresado;
        
        System.out.println("A");
        while(true) {
            System.out.println("B");
            String nombreDeUsuarioAValidar = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            String claveAValidar = JOptionPane.showInputDialog("Ingrese una contraseña");
            System.out.println("nombreDeUsuarioAValidar: " + nombreDeUsuarioAValidar);
            System.out.println("claveAValidar: " + claveAValidar);
            System.out.println("nombre: " + usuarioA.getNombreDeUsuario());
            System.out.println("clave: " + usuarioA.getClave());
            usuarioIngresado = validarUsuario(nombreDeUsuarioAValidar, claveAValidar, usuarioA, usuarioB);
            if (usuarioIngresado != ""){
                JOptionPane.showMessageDialog(null, "Usuario correcto");
                break;

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                break;
            }
        }
    }
    
    public static String validarUsuario(String usuarioAValidar, String claveAValidar, Usuario usuarioA, Usuario usuarioB){
        System.out.println(usuarioAValidar.equals(usuarioA.getNombreDeUsuario()));
        if(usuarioAValidar.equals(usuarioA.getNombreDeUsuario()) && claveAValidar.equals(usuarioA.getClave())) {
            return usuarioA.getClave();
        } else if(usuarioAValidar.equals(usuarioB.getNombreDeUsuario()) && claveAValidar.equals(usuarioB.getClave())) {
            return usuarioB.getClave();
        } else {
            return "";
        }
    }
}
