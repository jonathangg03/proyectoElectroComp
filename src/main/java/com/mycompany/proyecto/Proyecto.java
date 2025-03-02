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
        
        while(true) {
            String nombreDeUsuarioAValidar = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            String claveAValidar = JOptionPane.showInputDialog("Ingrese una contraseña");
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
        if(usuarioAValidar.equals(usuarioA.getNombreDeUsuario()) && claveAValidar.equals(usuarioA.getClave())) {
            return usuarioA.getClave();
        } else if(usuarioAValidar.equals(usuarioB.getNombreDeUsuario()) && claveAValidar.equals(usuarioB.getClave())) {
            return usuarioB.getClave();
        } else {
            return "";
        }
    }
}
