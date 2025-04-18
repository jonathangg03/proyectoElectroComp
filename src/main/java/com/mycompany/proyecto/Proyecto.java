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
        int cantidadUsuarios = 5;
        Usuario usuarios[] = new Usuario[20];
        usuarios[0] = new Usuario("Jonathan Garcia", "jona", "12", Rol.ADMINISTRADOR);
        usuarios[1] = new Usuario("Nayeli Reyes", "nayeli23r", "9qWIn9xkwO", Rol.ADMINISTRADOR);
        usuarios[2] = new Usuario("Jose Soto", "scrooge4340", "8DKe6nysAP", Rol.TECNICO);
        usuarios[3] = new Usuario("Ana Campos", "lather4375", "WGfCz", Rol.TECNICO);
        usuarios[4] = new Usuario("Maria Perez", "cussed8408", "6U0MYcer", Rol.TECNICO);
        
        
        
        Orden ordenA = new Orden(1, 1, 1, "celular", "Samsung", "A23", "Pantalla dañada", "asignada");
        Orden ordenB = new Orden(2, 2, 2, "computador", "HP", "124", "Baria no carga", "asignada");
        
        Cliente clienteA = new Cliente("disponible", "0", 0, 0.0);
        Cliente clienteB = new Cliente("disponible", "0", 0, 0.0);
        
        while(true) {
            String nombreDeUsuarioAValidar = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            Usuario usuarioEncontrado = validarNombreUsuario(usuarios, nombreDeUsuarioAValidar);
            
            if (nombreDeUsuarioAValidar.equals(null)) { // Cerrar con la x o Cancelar
                break;
            }

            if (usuarioEncontrado.getEstado().equals(Estado.ACTIVO)) { //Validar si el usuario está activo
                if (usuarioEncontrado != null) { // Se econtro usuario
                    int intentosClave = 1;
                    while (intentosClave <= 3) {
                        String claveAValidar = JOptionPane.showInputDialog("Ingrese una contraseña");
                        boolean claveAceptada = validarClave(usuarioEncontrado, claveAValidar);
                        if (claveAceptada == true) { //Constraseña coincide
                            while (usuarioEncontrado != null) {
                                int opcionEscogida = desplegarMenuPrincipal(usuarioEncontrado);
                                // cantidadUsuarios = ejecutarAccionMenuPrincipal(usuarioEncontrado, opcionEscogida, usuarios, ordenA, ordenB, clienteA, clienteB, cantidadUsuarios);
                                switch (opcionEscogida) {
                                    case 1:
                                        // Mostrar clientes
                                        if (!clienteA.getDni().equals("0")) {
                                            clienteA.mostrarInformacion();
                                        }
                                        if (!clienteB.getDni().equals("0")) {
                                            clienteB.mostrarInformacion();
                                        }
                                        break;
                                    case 2:
                                        // Mostrar usuarios
                                        for (int i = 0; i < usuarios.length; i++) {
                                            if (usuarios[i] != null) {
                                                usuarios[i].mostrarTodosLosDatos();
                                            }
                                        }
                                        break;
                                    case 3:
                                        // Mostrar ordenes
                                        ordenA.mostrarOrden();
                                        ordenB.mostrarOrden();
                                        break;
                                    case 4:
                                        // Crear cliente
                                        if (clienteA.getDni().equals("0")) {
                                            agregarCliente(clienteA);
                                        } else {
                                            agregarCliente(clienteB);
                                        }

                                        break;
                                    case 5:
                                        // Crear usuario
                                        int nuevaCantidad = agregarUsuario(usuarios, cantidadUsuarios);
                                        cantidadUsuarios = nuevaCantidad;
                                        break;
                                    case 6:
                                        // Agregar orden
                                        crearOrden();
                                        break;
                                    case 8:
                                        buscarUsuario(usuarios);
                                    case 11:
                                        usuarioEncontrado = null;
                                        break;
                                }
                            }
                            break;
                        } else { //Contraseña no coincide
                            intentosClave = intentosClave + 1;
                            System.out.println(intentosClave);
                            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                            if (intentosClave > 3) {
                                usuarioEncontrado.setEstado(Estado.INACTIVO);
                                JOptionPane.showMessageDialog(null, "El usuario se desactivo por ingresar multiples veces la clave.");
                            }
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario inactivo");
            }
        }
    }
    
    public static Usuario validarNombreUsuario(Usuario usuarios[], String nombreDeUsuarioAValidar) {
        for (int i = 0; i < usuarios.length; i++) {
            if(usuarios[i] != null){
                if(usuarios[i].getNombreDeUsuario().equals(nombreDeUsuarioAValidar)){
                    return usuarios[i];
                }
            }
        }
        
        return null;
    }
    
    public static boolean validarClave(Usuario usuarioEncontrado, String claveAValidar) {
        if(usuarioEncontrado.getClave().equals(claveAValidar)) {
            return true;
        } else {
            return false;
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
    
//    public static int ejecutarAccionMenuPrincipal(Usuario usuarioEncontrado, int opcionEscogida, Usuario usuarios[] ,Orden ordenA, Orden ordenB, Cliente clienteA, Cliente clienteB, int cantidadUsuarios) {
//
//        return cantidadUsuarios;
//    }
    
//    public static Cliente agregarCliente() {
//        
//    }
    
    public static int agregarUsuario(Usuario usuarios[], int cantidadUsuarios) {
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del usuario");
        String nombreDeUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
        String clave = JOptionPane.showInputDialog("Ingrese la contraseña");
        Rol rol = Rol.TECNICO;
        
        
        String opcionesRol[] = {"Administrador", "Tecnico"};
        int seleccionRol = JOptionPane.showOptionDialog(null, "Indique el rol del usuario", "Rol: ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesRol, opcionesRol[1]);
        
        if(seleccionRol == 0) {
            rol = Rol.ADMINISTRADOR;
        }
        
        usuarios[cantidadUsuarios] = new Usuario(nombreCompleto, nombreDeUsuario, clave, rol );
        JOptionPane.showMessageDialog(null, "El usuario " + nombreDeUsuario + " se agregó correctamente");
        cantidadUsuarios = cantidadUsuarios + 1;
        return cantidadUsuarios;
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
     
     public static Cliente agregarCliente(Cliente cliente) {
         cliente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente"));
         cliente.setDni(JOptionPane.showInputDialog("Ingrese el DNI del cliente"));
         cliente.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente")));
         cliente.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo del cliente")));
         
         JOptionPane.showMessageDialog(null, "El cliente con el DNI " + cliente.getDni() + " se agrego exitosamente");
         
         return cliente;
     }

    public static void buscarUsuario(Usuario usuarios[]) {
        String opcionesBusqueda[] = {"Por usuario", "Por codigo", "Cancelar"};
        int seleccionBusqueda = JOptionPane.showOptionDialog(null, "Escoja una de las siguientes opciones de busqueda", "Buscar usuario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBusqueda, opcionesBusqueda[2]);
        int usuarioEncontrado = -1;

        while (usuarioEncontrado == -1) {
            switch (seleccionBusqueda) {
                case 0: // Busqueda por usuario
                    String usuarioABuscar = JOptionPane.showInputDialog("Por favor, ingrese el nombre de usuario a buscar");
                    modificarUsuario(usuarios, usuarioEncontrado, seleccionBusqueda, usuarioABuscar);
                    break;
                case 1: // Busqueda por codigo
                    usuarioABuscar = JOptionPane.showInputDialog("Por favor, ingrese el codigo de usuario a buscar");
                    modificarUsuario(usuarios, usuarioEncontrado, seleccionBusqueda, usuarioABuscar);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Busqueda cancelada");
                    usuarioEncontrado = -2;
                    break;
            }
        }
    }
    
    public static int modificarUsuario(Usuario usuarios[], int usuarioEncontrado, int seleccionBusqueda, String usuarioABuscar) {
        usuarioEncontrado = busqueda(usuarios, seleccionBusqueda, usuarioABuscar);
        if (usuarioEncontrado != -1) {
            JOptionPane.showMessageDialog(null,
                    "Codigo: " + usuarios[usuarioEncontrado].getCodigo()
                    + "Nombre completo: " + usuarios[usuarioEncontrado].getNombreCompleto()
                    + "Nombre de usuario: " + usuarios[usuarioEncontrado].getNombreDeUsuario()
                    + "Clave: " + cifrarClave(usuarios[usuarioEncontrado].getNombreDeUsuario())
                    + "Estado: " + usuarios[usuarioEncontrado].getEstado()
                    + "Rol: " + usuarios[usuarioEncontrado].getRol()
            );
            String opcionesDeCambio[] = {"Actualizar", "Activar-Desactivar", "Cancelar"};
            if (usuarios[usuarioEncontrado].getEstado() == Estado.ACTIVO) {
                opcionesDeCambio[1] = "Desactivar";
            } else {
                opcionesDeCambio[1] = "Activar";
            }
            int seleccionACambiar = JOptionPane.showOptionDialog(null, "Escoja lo que se hará con el usuario encontrado", "Usuario: " + usuarios[usuarioEncontrado].getCodigo(),
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesDeCambio, opcionesDeCambio[2]);

            switch (seleccionACambiar) {
                case 0: // Actualizar
                    actualizarUsuario(usuarios, usuarioEncontrado);
                    break;
                case 1: // Activar-Desactivar
                    if (usuarios[usuarioEncontrado].getEstado().equals(Estado.ACTIVO)) {
                        usuarios[usuarioEncontrado].setEstado(Estado.INACTIVO);
                        JOptionPane.showMessageDialog(null, "Se ha desactivado el usuario");
                    } else {
                        usuarios[usuarioEncontrado].setEstado(Estado.ACTIVO);
                        JOptionPane.showMessageDialog(null, "Se ha activado el usuario");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción");  
            }
            usuarioEncontrado = -1;
        }
        
        return usuarioEncontrado;
    }
    
    public static void actualizarUsuario(Usuario usuarios[], int usuarioEncontrado) {
        String opcionesDeCambio[] = {"Nombre completo", "Usuario", "Clave", "Cancelar"};
        int seleccionACambiar = JOptionPane.showOptionDialog(null, "Indique que desea actualizar", "Usuario: " + usuarios[usuarioEncontrado].getCodigo(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesDeCambio, opcionesDeCambio[3]);
        
        switch (seleccionACambiar) {
            case 1: // Cambiar nombre completo
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre completo");
                usuarios[usuarioEncontrado].setNombreCompleto(nuevoNombre);
                JOptionPane.showMessageDialog(null, "Modificó exitosamente el usuario con el codigo " + usuarios[usuarioEncontrado].getCodigo());
                break;
            case 2: // Cambiar nombre de usuario
                String nuevoUsuario = JOptionPane.showInputDialog("Ingrese el nuevo nombre de usuario");
                boolean usuarioExistente = false;
                while (!usuarioExistente) {
                    for (int i = 0; i < usuarios.length; i++) {
                        if (usuarios[i] != null) {
                            if (usuarios[i].getNombreDeUsuario().equals(nuevoUsuario)) {
                                usuarioExistente = true;
                            }
                        }
                    }
                    if (usuarioExistente) {
                        JOptionPane.showMessageDialog(null, "El usuario ya existe");
                        String opcionesUsuario[] = {"Agregar otro usuario", "Cancelar"};
                        int seleccionUsuarioRepetido = JOptionPane.showOptionDialog(null, "Indique que desea hacer", "Usuario repetido",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesUsuario, opcionesUsuario[1]);
                        if(seleccionUsuarioRepetido == 0) {
                            usuarioExistente = false;
                        }
                    } else {
                        usuarios[usuarioEncontrado].setNombreUusario(nuevoUsuario);
                        JOptionPane.showMessageDialog(null, "Se modificó el nombre de usuario correctamente");
                        usuarioExistente = true;
                    }
                }
                break;
            case 3: // Cambiar contraseña
                String nuevaClave = JOptionPane.showInputDialog("Ingrese la nueva contraseña que cumpla las siguientes condiciones: \n"
                        + "Entre 8 y 16 caracteres \n"
                        + "Contener al menos un número \n"
                        + "Contener al menos una letra");
                boolean tieneNumero = false;
                boolean tieneLetra = false;
                boolean coinciden = false;
                
                while(!tieneNumero && !tieneLetra) {
                    for (int i = 0; i < nuevaClave.length(); i++) {
                        if((nuevaClave.charAt(i) >= 'A' && nuevaClave.charAt(i) < 'Z') || (nuevaClave.charAt(i) >= 'A' && nuevaClave.charAt(i) < 'Z')){
                            tieneLetra = true;
                        }
                        
                        if(nuevaClave.charAt(i) >= '0' && nuevaClave.charAt(i) < '9') {
                            tieneNumero = true;
                        }
                    }
                    
                    if (!tieneNumero || !tieneLetra) {
                        String opcionesClave[] = {"Volver a ingresar", "Cancelar"};
                        JOptionPane.showMessageDialog(null, "La contraseña no cumple los parametros requeridos");
                        int seleccionVolverClave = JOptionPane.showOptionDialog(null, "Indique que desea hacer", "Error contraseña",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesClave, opcionesClave[1]);
                        if(seleccionVolverClave == 0) {
                            tieneNumero = false;
                            tieneLetra = false;
                        } else {
                            break;
                        }
                    }
                }
                
                if (tieneLetra && tieneNumero) {
                    while(!coinciden) {
                        String confirmacion = JOptionPane.showInputDialog("Por favor, confirme la contraseña");
                        if(confirmacion.equals(nuevaClave)) {
                            coinciden = true;
                            JOptionPane.showMessageDialog(null, "Se cambio la contraseña exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                            String opcionesClave[] = {"Volver a confirmar", "Cancelar"};
                            int seleccionVolverConfirmacion = JOptionPane.showOptionDialog(null, "Volver a confirmar", "Error contraseña",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesClave, opcionesClave[1]);
                            if(seleccionVolverConfirmacion != 0) {
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción");
        }

    }
    
    public static int busqueda(Usuario usuarios[], int seleccionBusqueda, String valorDeBusqueda) {
        int usuarioEncontrado = -1;

        if (seleccionBusqueda == 0) {
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i] != null) {
                    if (usuarios[i].getNombreDeUsuario().equals(valorDeBusqueda)) {
                        usuarioEncontrado = i;
                    }
                }
            }
        } else {
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i] != null) {
                    if (usuarios[i].getCodigo().equals(valorDeBusqueda)) {
                        usuarioEncontrado = i;
                    }
                }
            }
        }
        
        if (usuarioEncontrado == -1 && seleccionBusqueda == 0) {
            JOptionPane.showMessageDialog(null, "El Usuario con el nombre de usuario: " + valorDeBusqueda + " no se encuentra registrado en el sistema");
        }
        
        if (usuarioEncontrado == -1 && seleccionBusqueda == 1) {
            JOptionPane.showMessageDialog(null, "El Usuario con el codigo: " + valorDeBusqueda + " no se encuentra registrado en el sistema");
        }
        
        return usuarioEncontrado;
    }
    
    public static String cifrarClave(String clave) {
        String claveCifrada = "";
        
        for(int i = 0; i < clave.length(); i++ ) {
            claveCifrada += "*";
        }
                
        return claveCifrada;
    }
    
}
