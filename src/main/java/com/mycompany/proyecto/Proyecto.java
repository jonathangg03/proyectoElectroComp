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
        Usuario usuarioA = new Usuario(1,"Sebastian Garcia", "sgarcia03", "1234as", Rol.ADMINISTRADOR);
        Usuario usuarioB = new Usuario(2,"Keneth Gonzalez", "kengo20", "5678df", Rol.TECNICO);
        Usuario usuarioC = new Usuario(3,"pendiente", "pendiente", "pendiente", Rol.TECNICO);
        Usuario usuarioD = new Usuario(4,"pendiente", "pendiente", "pendiente", Rol.TECNICO);
        
        Orden ordenA = new Orden(1, 1, 1, "celular", "Samsung", "A23", "Pantalla dañada", "asignada");
        Orden ordenB = new Orden(2, 2, 2, "computador", "HP", "124", "Baria no carga", "asignada");
        Usuario usuarioIngresado;
        
        while(true) {
            String nombreDeUsuarioAValidar = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            String claveAValidar = JOptionPane.showInputDialog("Ingrese una contraseña");
            usuarioIngresado = validarUsuario(nombreDeUsuarioAValidar, claveAValidar, usuarioA, usuarioB);
            if (usuarioIngresado.getNombreDeUsuario() == "desconocido"){
                // Usuario incorrecto
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            } else {
                // Usuario correcto
                JOptionPane.showMessageDialog(null, "Bienvenido");
                while(usuarioIngresado.getNombreDeUsuario().length() > 0) {
                    int opcionEscogida = desplegarMenuPrincipal(usuarioIngresado);
                    ejecutarAccionMenuPrincipal(usuarioIngresado, opcionEscogida, usuarioA, usuarioB, usuarioC, usuarioD ,ordenA, ordenB);
                }
            }
        }
    }
    
    public static Usuario validarUsuario(String usuarioAValidar, String claveAValidar, Usuario usuarioA, Usuario usuarioB){
        if(usuarioAValidar.equals(usuarioA.getNombreDeUsuario()) && claveAValidar.equals(usuarioA.getClave())) {
            return usuarioA;
        } 
        else if(usuarioAValidar.equals(usuarioB.getNombreDeUsuario()) && claveAValidar.equals(usuarioB.getClave())) {
            return usuarioB;
        } else {
            Usuario usuarioDesconocido = new Usuario(0, "desconocido", "desconocido", "desconocido" , Rol.TECNICO);
            return usuarioDesconocido ;
        }
    }
    
    public static int desplegarMenuPrincipal(Usuario usuarioActual){
        int opcionMenuPrincipal;
        if(usuarioActual.getRol() == Rol.ADMINISTRADOR){
        opcionMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número dependiendo de las siguientes opciones: "
                    + "\n 1. Mostrar clientes"
                    + "\n 2. Mostrar usuarios"
                    + "\n 3. Mostrar ordenes de servicio"
                    + "\n 4. Agregar nuevo cliente"
                    + "\n 5. Agregar nuevo usuarlo"
                    + "\n 6. Crear orden de servicio"
                    + "\n 7. Buscar cliente"
                    + "\n 8. Buscar usuario"
                    + "\n 9. Buscar orden de serviclo"
                    + "\n 10. Generar reportes"
                    + "\n 11. Cerrar sesión"));
        } else {
            opcionMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número dependiendo de las siguientes opciones: "
                    + "\n 1. Mostrar clientesMostrar ordenes de servicios"
                    + "\n 2. Buscar ordenes de servicios"
                    + "\n 3. Cerrar sesión"
                    + "\n 4.Salir del sistema"));
        }
        
        return opcionMenuPrincipal;
    }
    
    public static void ejecutarAccionMenuPrincipal(Usuario usuarioIngresado, int opcionEscogida, Usuario usuarioA, Usuario usuarioB, Usuario usuarioC, Usuario usuarioD ,Orden ordenA, Orden ordenB) {
        switch(opcionEscogida) {
            case 1:
                // Mostrar clientes
                break;
            case 2:
                // Mostrar usuarios
                usuarioA.mostrarTodosLosDatos();
                usuarioB.mostrarTodosLosDatos();
                if (!usuarioC.getNombreDeUsuario().equals("pendiente")) {
                    usuarioC.mostrarTodosLosDatos();
                }
                if (!usuarioD.getNombreDeUsuario().equals("pendiente")) {
                    usuarioD.mostrarTodosLosDatos();
                }
                break;
            case 3:
                // Mostrar ordenes
                ordenA.mostrarOrden();
                ordenB.mostrarOrden();
                break;
            case 4:
                // Crear cliente
//                agregarCliente();
                break;
            case 5:
                // Crear usuario
                if(usuarioC.getNombreDeUsuario().equals("pendiente")) {
                    agregarUsuario(usuarioC);
                }else {
                    agregarUsuario(usuarioD);
                }
                break;
            case 6:
                // Agregar orden
                crearOrden();
                break;
            case 11:
                usuarioIngresado.setNombreUusario("");
                break;
                
        }
    }
    
//    public static Cliente agregarCliente() {
//        
//    }
    
    public static Usuario agregarUsuario(Usuario usuarioAAgregar) {
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del usuario");
        String nombreDeUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
        String clave = JOptionPane.showInputDialog("Ingrese la contraseña");
        String rolEscogido = "";
        Rol rol = Rol.TECNICO;
        while(!rolEscogido.toLowerCase().equals("administrador") && !rolEscogido.toLowerCase().equals("tecnico")) {
            rolEscogido = JOptionPane.showInputDialog("Ingrese el rol del usuario: administrador o tecnico");
            if(rolEscogido.toLowerCase().equals("administrador")) {
                rol = Rol.ADMINISTRADOR;
            }
            else if(rolEscogido.toLowerCase().equals("tecnico")) {
                rol = Rol.TECNICO;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida: tecnico o administrador");
            }
        }
        
        usuarioAAgregar.setNombreCompleto(nombreCompleto);
        usuarioAAgregar.setNombreUusario(nombreDeUsuario);
        usuarioAAgregar.setClave(clave);
        usuarioAAgregar.setRol(rol);
        JOptionPane.showMessageDialog(null, "El usuario " + usuarioAAgregar.getNombreDeUsuario() + " se agregó correctamente");
        return usuarioAAgregar;
    }
    
     public static Orden crearOrden() {
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente"));
        int codigoTecnico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del tecnico"));
        String dispositivo = JOptionPane.showInputDialog("Ingrese el dispositivo a atender");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del dispositivo");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del dispositivo");
        String problema = JOptionPane.showInputDialog("Ingrese el problema que tiene el dispositivo");
        
        Orden nuevaOrden = new Orden(3, idCliente, codigoTecnico, dispositivo, marca, modelo, problema, "asignada");
        JOptionPane.showMessageDialog(null, "La orden número " + nuevaOrden.getOrdenNum()+ " se agregó correctamente");
        return nuevaOrden;
     }
}