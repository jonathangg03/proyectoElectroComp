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
        usuarios[3] = new Usuario("Ana Campos", "lather4375", "WGf", Rol.TECNICO);
        usuarios[4] = new Usuario("Maria Perez", "cussed8408", "6U0MYcer", Rol.TECNICO);
        
        
        Orden ordenA = new Orden(1, 1, 1, "celular", "Samsung", "A23", "Pantalla dañada", "asignada");
        Orden ordenB = new Orden(2, 2, 2, "computador", "HP", "124", "Baria no carga", "asignada");
        
        int cantidadClientes = 8;
        Cliente clientes[] = new Cliente[30];
        clientes[0] = new Cliente("A1", "Jorge Soto", "1111-1111", "jsoto@mail.com", TipoCliente.PREMIUM);
        clientes[1] = new Cliente("A2", "Valeria Mendoza", "2222-2222", "vmendoza@mail.com", TipoCliente.PLATINO);
        clientes[2] = new Cliente("A3", "Andrés Cortés", "3333-2222", "acortes@mail.com", TipoCliente.ORO);
        clientes[3] = new Cliente("A4", "Camila Ríos", "4444-2222", "crios@mail.com", TipoCliente.PREMIUM);
        clientes[4] = new Cliente("A5", "Tomás Herrera", "5555-2222", "therrera@mail.com", TipoCliente.PLATINO);
        clientes[5] = new Cliente("A6", "Natalia Zamora", "6666-2222", "nzamora@mail.com", TipoCliente.ORO);
        clientes[6] = new Cliente("A7", "Joaquín Salinas", "7777-2222", "jsalinas@mail.com", TipoCliente.PREMIUM);
        clientes[7] = new Cliente("A8", "Mariana Paredes", "8888-2222", "mparedes@mail.com", TipoCliente.PLATINO);
        
        while(true) {
            String nombreDeUsuarioAValidar = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            Usuario usuarioEncontrado = validarNombreUsuario(usuarios, nombreDeUsuarioAValidar);
            
            if (nombreDeUsuarioAValidar == null) { // Cerrar con la x o Cancelar
                break;
            }
            
            if (usuarioEncontrado != null) { // Se econtro usuario
                if (usuarioEncontrado.getEstado().equals(Estado.ACTIVO)) { //Validar si el usuario está activo
                    int intentosClave = 1;
                    while (intentosClave <= 3) {
                        String claveAValidar = JOptionPane.showInputDialog("Ingrese una contraseña");
                        if(claveAValidar == null) {
                            break;
                        }
                        boolean claveAceptada = validarClave(usuarioEncontrado, claveAValidar);
                        if (claveAceptada == true) { //Constraseña coincide
                            while (usuarioEncontrado != null) {
                                // int opcionEscogida = desplegarMenuPrincipal(usuarioEncontrado);
                                String opcionEscogida = "";
                                if (usuarioEncontrado.getRol() == Rol.ADMINISTRADOR) {
                                    opcionEscogida = JOptionPane.showInputDialog("Ingrese un número dependiendo de las siguientes opciones: "
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
                                            + "\n 11. Cerrar sesión"
                                            + "\n 12. Salir del sistema");
                                    if (opcionEscogida == null) {
                                        break;
                                    }
                                } else {
                                    opcionEscogida = JOptionPane.showInputDialog("Ingrese un número dependiendo de las siguientes opciones: "
                                            + "\n 1. Mostrar ordenes de servicios"
                                            + "\n 2. Buscar ordenes de servicios"
                                            + "\n 3. Cerrar sesión"
                                            + "\n 4. Salir del sistema");
                                    if (opcionEscogida == null) {
                                        break;
                                    }
                                }
                                if (usuarioEncontrado.getRol() == Rol.ADMINISTRADOR) {
                                    switch (opcionEscogida) {
                                        case "1":
                                            // Mostrar clientes
                                            for (int i = 0; i < clientes.length; i++) {
                                                if (clientes[i] != null) {
                                                    clientes[i].mostrarTodosLosDatos();
                                                }
                                            }
                                            break;
                                        case "2":
                                            // Mostrar usuarios
                                            for (int i = 0; i < usuarios.length; i++) {
                                                if (usuarios[i] != null) {
                                                    usuarios[i].mostrarTodosLosDatos();
                                                }
                                            }
                                            break;
                                        case "3":
                                            // Mostrar ordenes
                                            ordenA.mostrarOrden();
                                            ordenB.mostrarOrden();
                                            break;
                                        case "4":
                                            // Crear cliente
                                            int nuevaCantidadClientes = agregarCliente(clientes, cantidadClientes);
                                            cantidadClientes = nuevaCantidadClientes;
                                            break;
                                        case "5":
                                            // Crear usuario
                                            int nuevaCantidadUsuarios = agregarUsuario(usuarios, cantidadUsuarios);
                                            cantidadUsuarios = nuevaCantidadUsuarios;
                                            break;
                                        case "6":
                                            // Agregar orden
                                            crearOrden();
                                            break;
                                        case "7":
                                            buscarCliente(clientes);
                                            break;
                                        case "8": // Bucar usuario
                                            buscarUsuario(usuarios);
                                            break;
                                        case "11": // Cerrar sesión
                                            usuarioEncontrado = null;
                                            break;
                                        case "12":
                                            return;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Seleccione una opcion valida");
                                    }
                                } else{
                                    switch (opcionEscogida) {
                                        case "1": //Mostrar ordenes de servicio del tecnico
                                            break;
                                        case "2": //Buscar orden de servicio del tecnico
                                            break;
                                        case "3": //Cerrar sesión
                                            usuarioEncontrado = null;
                                            break;
                                        case "4": //Salir del sistema
                                            return;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Seleccione una opcion valida");
                                    }
                                }
                            }
                            break;
                        } else { //Contraseña no coincide
                            intentosClave = intentosClave + 1;
                            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                            if (intentosClave > 3) {
                                usuarioEncontrado.setEstado(Estado.INACTIVO);
                                JOptionPane.showMessageDialog(null, "El usuario se desactivo por ingresar multiples veces la clave.");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no está activo");
                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe");
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
    
    public static int agregarUsuario(Usuario usuarios[], int cantidadUsuarios) {
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del usuario");
        
        boolean usuarioDisponible = true;
        boolean correcto = false;
        String nombreDeUsuario = "";
        while(usuarioDisponible == true) {
            nombreDeUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            for(int i = 0; i < usuarios.length; i++) {
                if(usuarios[i] != null) {
                    if (usuarios[i].getNombreDeUsuario().equals(nombreDeUsuario)) {
                        usuarioDisponible = false;
                    }
                }
            }
            
            if(usuarioDisponible == false) {
                JOptionPane.showMessageDialog(null, "Usuario ya agregado en el sistema");
                String opcionesVolverAgregar[] = {"Agregar otro usuario", "Cancelar"};
                int volverAgregar = JOptionPane.showOptionDialog(null, "Ingresar usuario nuevamente", "Volver a agregar",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesVolverAgregar, opcionesVolverAgregar[1]);
                if(volverAgregar == 0) {
                    usuarioDisponible = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se agrego usuario. Volviendo al menú principal");
                }
            } else {
                usuarioDisponible = false;
                correcto = true;
            }
        }
        
        if (correcto == true) {
            String nuevaClave = "";
            boolean tieneNumero = false;
            boolean tieneLetra = false;
            boolean coinciden = false;
            boolean cumple = true;

            while (!tieneNumero && !tieneLetra) {
                nuevaClave = JOptionPane.showInputDialog("Ingrese la nueva contraseña que cumpla las siguientes condiciones: \n"
                        + "Entre 8 y 16 caracteres \n"
                        + "Contener al menos un número \n"
                        + "Contener al menos una letra");

                if (nuevaClave == null) { // Cerrar con la x o Cancelar
                    break;
                }
                for (int i = 0; i < nuevaClave.length(); i++) {
                    if ((nuevaClave.charAt(i) >= 'A' && nuevaClave.charAt(i) < 'Z') || (nuevaClave.charAt(i) >= 'a' && nuevaClave.charAt(i) < 'z')) {
                        tieneLetra = true;
                    }

                    if (nuevaClave.charAt(i) >= '0' && nuevaClave.charAt(i) < '9') {
                        tieneNumero = true;
                    }
                }

                if (tieneNumero == false || tieneLetra == false) {
                    JOptionPane.showMessageDialog(null, "La clave no coincide con los parametros");
                    cumple = false;
                    String opcionesClave[] = {"Volver a ingresar", "Cancelar"};
                    int seleccionVolverClave = JOptionPane.showOptionDialog(null, "Indique que desea hacer", "Error contraseña",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesClave, opcionesClave[1]);
                    if (seleccionVolverClave == 0) {
                        tieneNumero = false;
                        tieneLetra = false;
                    } else {
                        break;
                    }
                }
            }

            if (tieneLetra && tieneNumero) {
                while (coinciden == false) {
                    String confirmacion = JOptionPane.showInputDialog("Por favor, confirme la contraseña");
                    if (confirmacion.equals(nuevaClave)) {
                        coinciden = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                        cumple = false;
                        String opcionesClave[] = {"Volver a confirmar", "Cancelar"};
                        int seleccionVolverConfirmacion = JOptionPane.showOptionDialog(null, "Volver a confirmar", "Error contraseña",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesClave, opcionesClave[1]);
                        if (seleccionVolverConfirmacion != 0) {
                            break;
                        }
                    }
                }
            }

            if (cumple == true) {
                Rol rol = Rol.TECNICO;

                String opcionesRol[] = {"Administrador", "Tecnico"};
                int seleccionRol = JOptionPane.showOptionDialog(null, "Indique el rol del usuario", "Rol: ",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesRol, opcionesRol[1]);

                if (seleccionRol == 0) {
                    rol = Rol.ADMINISTRADOR;
                }

                usuarios[cantidadUsuarios] = new Usuario(nombreCompleto, nombreDeUsuario, nuevaClave, rol);
                JOptionPane.showMessageDialog(null, "El usuario " + nombreDeUsuario + " se agregó correctamente");
                cantidadUsuarios = cantidadUsuarios + 1;
            }
        }
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

         
         return cliente;
     }

    public static void buscarUsuario(Usuario usuarios[]) {
        String opcionesBusqueda[] = {"Por usuario", "Por codigo", "Cancelar"};
        int usuarioEncontrado = -1;

        while (usuarioEncontrado == -1) {
            int seleccionBusqueda = JOptionPane.showOptionDialog(null, "Escoja una de las siguientes opciones de busqueda", "Buscar usuario",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBusqueda, opcionesBusqueda[2]);
            switch (seleccionBusqueda) {
                case 0: // Busqueda por usuario
                    String usuarioABuscar = JOptionPane.showInputDialog("Por favor, ingrese el nombre de usuario a buscar");
                    if (usuarioABuscar != null) {
                        modificarUsuario(usuarios, usuarioEncontrado, seleccionBusqueda, usuarioABuscar);
                    }
                    break;
                case 1: // Busqueda por codigo
                    usuarioABuscar = JOptionPane.showInputDialog("Por favor, ingrese el codigo de usuario a buscar");
                    if (usuarioABuscar != null) {
                        modificarUsuario(usuarios, usuarioEncontrado, seleccionBusqueda, usuarioABuscar);
                    }
                    break;
                default:
                    usuarioEncontrado = 2;
                    break;
            }
        }
    }

    public static int modificarUsuario(Usuario usuarios[], int usuarioEncontrado, int seleccionBusqueda, String usuarioABuscar) {
        usuarioEncontrado = busqueda(usuarios, seleccionBusqueda, usuarioABuscar);
        if (usuarioEncontrado != -1) {
            JOptionPane.showMessageDialog(null,
                    "Codigo: " + usuarios[usuarioEncontrado].getCodigo() + "\n"
                    + "Nombre completo: " + usuarios[usuarioEncontrado].getNombreCompleto() + "\n"
                    + "Nombre de usuario: " + usuarios[usuarioEncontrado].getNombreDeUsuario() + "\n"
                    + "Clave: " + cifrarClave(usuarios[usuarioEncontrado].getNombreDeUsuario()) + "\n"
                    + "Estado: " + usuarios[usuarioEncontrado].getEstado() + "\n"
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
            case 0: // Cambiar nombre completo
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre completo");
                usuarios[usuarioEncontrado].setNombreCompleto(nuevoNombre);
                JOptionPane.showMessageDialog(null, "Modificó exitosamente el usuario con el codigo " + usuarios[usuarioEncontrado].getCodigo());
                break;
            case 1: // Cambiar nombre de usuario
                boolean usuarioDisponible = true;
                boolean correcto = false;
                String nombreDeUsuario = "";
                while (usuarioDisponible == true) {
                    nombreDeUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
                    for (int i = 0; i < usuarios.length; i++) {
                        if (usuarios[i] != null) {
                            if (usuarios[i].getNombreDeUsuario().equals(nombreDeUsuario)) {
                                usuarioDisponible = false;
                            }
                        }
                    }

                    if (usuarioDisponible == false) {
                        JOptionPane.showMessageDialog(null, "Usuario ya agregado en el sistema");
                        String opcionesVolverAgregar[] = {"Agregar otro usuario", "Cancelar"};
                        int volverAgregar = JOptionPane.showOptionDialog(null, "Ingresar usuario nuevamente", "Volver a agregar",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesVolverAgregar, opcionesVolverAgregar[1]);
                        if (volverAgregar == 0) {
                            usuarioDisponible = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "No se cambio el usuario.");
                        }
                    } else {
                        usuarioDisponible = false;
                        correcto = true;
                    }
                }
                if (correcto == true) {
                    usuarios[usuarioEncontrado].setNombreUusario(nombreDeUsuario);
                    JOptionPane.showMessageDialog(null, "Se modifico el usuario correctamente. El nuevo es: " + nombreDeUsuario);
                }
                break;
            case 2: // Cambiar contraseña
                String nuevaClave = "";
                boolean tieneNumero = false;
                boolean tieneLetra = false;
                boolean coinciden = false;
                boolean cumple = true;

                while (!tieneNumero && !tieneLetra) {
                    nuevaClave = JOptionPane.showInputDialog("Ingrese la nueva contraseña que cumpla las siguientes condiciones: \n"
                            + "Entre 8 y 16 caracteres \n"
                            + "Contener al menos un número \n"
                            + "Contener al menos una letra");

                    if (nuevaClave == null) { // Cerrar con la x o Cancelar
                        break;
                    }
                    for (int i = 0; i < nuevaClave.length(); i++) {
                        if ((nuevaClave.charAt(i) >= 'A' && nuevaClave.charAt(i) < 'Z') || (nuevaClave.charAt(i) >= 'a' && nuevaClave.charAt(i) < 'z')) {
                            tieneLetra = true;
                        }

                        if (nuevaClave.charAt(i) >= '0' && nuevaClave.charAt(i) < '9') {
                            tieneNumero = true;
                        }
                    }

                    if (tieneNumero == false || tieneLetra == false) {
                        JOptionPane.showMessageDialog(null, "La clave no coincide con los parametros");
                        cumple = false;
                        String opcionesClave[] = {"Volver a ingresar", "Cancelar"};
                        int seleccionVolverClave = JOptionPane.showOptionDialog(null, "Indique que desea hacer", "Error contraseña",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesClave, opcionesClave[1]);
                        if (seleccionVolverClave == 0) {
                            tieneNumero = false;
                            tieneLetra = false;
                        } else {
                            break;
                        }
                    }
                }

                if (tieneLetra && tieneNumero) {
                    while (coinciden == false) {
                        String confirmacion = JOptionPane.showInputDialog("Por favor, confirme la contraseña");
                        if (confirmacion.equals(nuevaClave)) {
                            coinciden = true;
                            cumple = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                            cumple = false;
                            String opcionesClave[] = {"Volver a confirmar", "Cancelar"};
                            int seleccionVolverConfirmacion = JOptionPane.showOptionDialog(null, "Volver a confirmar", "Error contraseña",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesClave, opcionesClave[1]);
                            if (seleccionVolverConfirmacion != 0) {
                                break;
                            }
                        }
                    }
                }
                if(cumple == true) {
                    usuarios[usuarioEncontrado].setClave(nuevaClave);
                    JOptionPane.showMessageDialog(null, "Se realizó el cambio de la contraseña exitosamente.");
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

    public static int agregarCliente(Cliente clientes[], int cantidadClientes) {
        String nuevoID = "";
        while (true) {
            boolean clienteExiste = false;
            nuevoID = JOptionPane.showInputDialog("Ingrese el ID del cliente");
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] != null) {
                    if (clientes[i].getId().equals(nuevoID)) {
                        clienteExiste = true;
                        break;
                    }
                }
            }
            if (clienteExiste == false) { // El ID no existe, es correcto
                break;
            } else { // El ID ya existe
                String opcionesRepetir[] = {"Agregar otro ID", "Cancelar"};
                int seleccionRepetir = JOptionPane.showOptionDialog(null, "ID ya existe. Desea ingresar oro?", "Error ID",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesRepetir, opcionesRepetir[1]);
                if (seleccionRepetir == 1) {
                    JOptionPane.showMessageDialog(null, "Se cancela el nuevo cliente");
                    return cantidadClientes;
                }
            }
        }

        if (nuevoID != null) {
            String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del cliente");
            String telefono = "";
            while (true) {
                telefono = JOptionPane.showInputDialog("Ingrese el número de teléfono del cliente en formato 0000-0000");
                boolean tamanoCorrecto = true;
                boolean formatoCorrecto = true;

                if (telefono != null) {
                    if (telefono.length() > 9) {
                        JOptionPane.showMessageDialog(null, "Formato incorrecto: Demasiados digitos");
                        formatoCorrecto = false;
                        tamanoCorrecto = false;
                    }

                    if (telefono.length() <= 0 || telefono.length() < 9) {
                        JOptionPane.showMessageDialog(null, "Formato incorrecto: Faltan digitos");
                        formatoCorrecto = false;
                        tamanoCorrecto = false;
                    }

                    if (tamanoCorrecto == true) { // Para qie no de error por el tamaño si no se coloca telefono
                        // Validar que los primeros 4 digitos sean números
                        for (int i = 0; i < 4; i++) {
                            if (telefono.charAt(i) < '0' || telefono.charAt(i) > '9') {
                                formatoCorrecto = false;
                                JOptionPane.showMessageDialog(null, "Formato incorrecto: Uno de los valores colocados no es numero");
                            }
                        }

                        if (telefono.charAt(4) != '-') {
                            formatoCorrecto = false;
                            JOptionPane.showMessageDialog(null, "Formato incorrecto: Faltó el guión del medio");
                        }

                        for (int i = 0; i < 4; i++) {
                            if (telefono.charAt(i) < '0' || telefono.charAt(i) > '9') {
                                formatoCorrecto = false;
                                JOptionPane.showMessageDialog(null, "Formato incorrecto: Uno de los valores colocados no es numero");
                            }
                        }
                    }

                    if (formatoCorrecto == true) {
                        break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor");
                }
            }

            String correo = "";
            int posicionArroba = 0;
            int posicionPunto = 0;
            boolean formatoCorreoCorrecto;
            
            while (true) {
                correo = JOptionPane.showInputDialog("Ingrese el correo electronico del cliente");
                formatoCorreoCorrecto = true;

                if (correo != null) {
                    posicionArroba = correo.indexOf('@');
                    posicionPunto = correo.indexOf('.', posicionArroba);

                    if (posicionArroba <= 0) {
                        formatoCorreoCorrecto = false;
                    }

                    if (posicionPunto == -1) {
                        formatoCorreoCorrecto = false;
                    }

                    if (formatoCorreoCorrecto == true) {
                        break;
                    } else {
                        String opcionesRepetir[] = {"Ingresar otro correo", "Cancelar"};
                        int seleccionRepetir = JOptionPane.showOptionDialog(null, "El correo tiene un formato incorrecto. Desea ingresar oro?", "Error correo",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesRepetir, opcionesRepetir[1]);
                        if(seleccionRepetir == 1) {
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un correo");
                }
            }

            if (formatoCorreoCorrecto == true) {
                TipoCliente tipoCliente;
                String opcionesTipo[] = {"Premium", "Platino", "Oro"};
                int seleccionRepetir = JOptionPane.showOptionDialog(null, "Seleccione el tipo de cliente", "Tipo de cliente",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesTipo, opcionesTipo[0]);
                switch (seleccionRepetir) {
                    case 0:
                        tipoCliente = TipoCliente.PREMIUM;
                        break;
                    case 1:
                        tipoCliente = TipoCliente.PLATINO;
                        break;
                    case 2:
                        tipoCliente = TipoCliente.ORO;
                        break;
                    default:
                        tipoCliente = TipoCliente.ORO;
                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguno, por defecto se seleccionará 1");
                        break;
                }

                clientes[cantidadClientes] = new Cliente(nuevoID, nombreCompleto, telefono, correo, tipoCliente);
                JOptionPane.showMessageDialog(null, "Usuario agregado correctamente: \n"
                        + "ID: " + nuevoID + "\n"
                        + "Nombre completo: " + nombreCompleto + "\n"
                        + "Teléfono: " + telefono + "\n"
                        + "Correo electronico: " + correo + "\n"
                        + "Tipo de cliente: " + tipoCliente);
                return cantidadClientes + 1;
            } else {
                return cantidadClientes;
            }

        } else {
            return cantidadClientes;
        }
    }
    
    public static void buscarCliente(Cliente clientes[]) {
        boolean clienteEncontrado = false;
        int indiceClienteEncontrado = -1;
        String idABuscar;
        while(true) {
            idABuscar = JOptionPane.showInputDialog("Ingrese el ID de un cliente para buscar");
            
            for(int i = 0; i < clientes.length; i++) {
                if(clientes[i] != null) {
                    if(clientes[i].getId().equals(idABuscar)){
                        clienteEncontrado = true;
                        indiceClienteEncontrado = i;
                    }
                }
            }
            
            if (clienteEncontrado == false) {
                String opcionesTipo[] = {"Ingresar otro ID", "Cancelar"};
                int seleccionRepetir = JOptionPane.showOptionDialog(null, "El cliente con el ID:" + idABuscar + " no se encuentra registrado en el sistema", "Cliente no encontrado",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesTipo, opcionesTipo[0]);
                if(seleccionRepetir == 1){
                    break;
                }
            }else {
                clientes[indiceClienteEncontrado].mostrarTodosLosDatosVentana();
                //AQUI IRAN LAS INSTRUCCIONES SI SE ENCUENTRA EL CLIENTE
                break;
            }
        }
    }
}
