/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 13/12/2023 9:06
*/

import java.util.*;//Importamos las librerias
import java.io.*;

public class Kayak{

    public static void main(String[] args){
        ArrayList<Paquete> usuarios = new ArrayList<Paquete>();
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        Paquete usuarioActual = null;
        Scanner scan = new Scanner(System.in);

        try{
            Scanner fileScan = new Scanner(new File("usuarios.csv"));
            fileScan.useDelimiter(";");

            if(fileScan.hasNextLine()){//Se salta la linea de titulos
                fileScan.nextLine();
            }

            while(fileScan.hasNextLine()){
                String[] usuariosData = fileScan.nextLine().split(";");

                switch(usuariosData[2]){
                    case "Basico":
                        Basico basico = new Basico(usuariosData[0], usuariosData[1]);
                        usuarios.add(basico);
                        break;
                    case "Premium":
                        Premium premium = new Premium(usuariosData[0], usuariosData[1]);
                        usuarios.add(premium);
                        break;
                }
            }
        }catch(Exception e){
            System.out.println("No se ha podido cargar el archivo. Motivo: " + e);
        }

        try{
            Scanner fileScan = new Scanner(new File("reservas.csv"));
            fileScan.useDelimiter(";");

            if(fileScan.hasNextLine()){//Se salta la linea de titulos
                fileScan.nextLine();
            }

            while(fileScan.hasNextLine()){
                String[] reservasData = fileScan.nextLine().split(";");
                Reserva reserva = new Reserva(reservasData[0],reservasData[1],Integer.parseInt(reservasData[4]),reservasData[5],reservasData[6],Integer.parseInt(reservasData[2]),reservasData[3],Integer.parseInt(reservasData[7]),Integer.parseInt(reservasData[8]));
                reservas.add(reserva);
            }
        }catch(Exception e){
            System.out.println("No se ha podido cargar el archivo. Motivo: " + e);
        }

        boolean salir = false;//Permite salir del programa
        boolean pass = false;//Sirve para saber si el usuario puede ingresar o no a su cuenta
        String seleccion;

        System.out.println("\n¡Bienvenido al sistema de reservas de Kayak!");

        while(!salir && !pass){//Menu de ingreso del usuario
            System.out.println("\n=== INGRESO ===");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Registrarse");           
            System.out.println("2. Iniciar Sesion");   
            System.out.println("3. Salir");

            seleccion = scan.nextLine();

            switch(seleccion){//Depende de la seleccion del usuario, se hace cada opcion del menu
                case "1":
                    usuarioActual = registrarUsuario(usuarios, usuarioActual);
                    pass = true;
                    break;
                case "2":
                    usuarioActual = ingresarUsuario(usuarios, usuarioActual);
                    pass = true;
                    System.out.println("\n¡Usuario ingresado correctamente!");
                    break;
                case "3":
                    salir = true;
                    break;
                default://Si mete un valor invalido
                    System.out.println("Ingrese un valor numerico valido");
            }
        }

        while(!salir){//Menu de opciones del usuario
            System.out.println("\n=== MENU DE OPCIONES ===");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Reservar un vuelo");           
            System.out.println("2. Confirmar/Pagar una reserva");  
            System.out.println("3. Modificar perfil");   
            System.out.println("4. Salir");

            seleccion = scan.nextLine();

            switch(seleccion){//Depende de la seleccion del jugador, se hace cada opcion del menu
                case "1":
                    hacerReserva(reservas, usuarioActual);
                    break;
                case "2":
                    confirmarReserva(reservas, usuarioActual);
                    guardarCSVReservas(reservas);
                    break;
                case "3":
                    usuarioActual = modificarPerfil(usuarios, usuarioActual);
                    break;                    
                case "4":

                    salir = true;
                    break;
                default://Si mete un valor invalido
                    System.out.println("Ingrese un valor numerico valido");
            } 
        }   
    }

    public static Paquete registrarUsuario(ArrayList<Paquete> usuarios, Paquete usuarioActual){
        String nombre;
        String contrasena; 
        String plan;
        Scanner scan = new Scanner(System.in);

        System.out.println("\n=== REGISTRO DE USUARIO ===");
        System.out.println("Registre su nombre");
        nombre = scan.nextLine();
        System.out.println("Registre su contraseña");
        contrasena = scan.nextLine();
        System.out.println("¿Que plan desea adquirir? 1. Basico, 2. Premium");
        plan = scan.nextLine();
        
        switch(plan){
            case "1":
                System.out.println("\nHas escogido plan Basico");
                usuarioActual = new Basico(nombre, contrasena);
                usuarios.add(usuarioActual);
                System.out.println("Usuario registrado correctamente");
                break;
            case "2":
                System.out.println("\nHas escogido plan Premium");
                usuarioActual = new Premium(nombre, contrasena);
                usuarios.add(usuarioActual);
                System.out.println("Usuario registrado correctamente");
                break;
            default: 
                System.out.println("Ingrese un valor numerico valido");
        }
        
        guardarCSVUsuarios(usuarios);
        return usuarioActual;
    }

    public static Paquete ingresarUsuario(ArrayList<Paquete> usuarios, Paquete usuarioActual){
        boolean pass = false;
        String nombre;
        String contrasena; 
        Scanner scan = new Scanner(System.in);

        while (!pass) {
            System.out.println("\n=== INICIAR SESION ===");
            System.out.println("Ingrese su nombre");
            nombre = scan.nextLine();
            System.out.println("Ingrese su contraseña");
            contrasena = scan.nextLine();

            for(Paquete usuario : usuarios){
                if(((Usuario)usuario).getNombre().equals(nombre) && ((Usuario)usuario).getContrasena().equals(contrasena)){
                    usuarioActual = (Paquete)usuario;
                    System.out.println(usuarioActual);
                    pass = true;
                    return usuarioActual;
                }
            }
            System.out.println("Usuario y/o contraseña incorrectos... Intentelo nuevamente");
        }
        return usuarioActual;
    }

    public static void hacerReserva(ArrayList<Reserva> reservas, Paquete usuarioActual){
        usuarioActual.reservaViaje();
    }

    public static void confirmarReserva(ArrayList<Reserva> reservas, Paquete usuarioActual){
        usuarioActual.confirmacionPago(reservas);
    }

    public static Paquete modificarPerfil(ArrayList<Paquete> usuarios, Paquete usuarioActual){
        Scanner scan = new Scanner(System.in);

        Reserva reserva = ((Usuario) usuarioActual).getReserva();
        usuarioActual.modificarPerfil();
        if(usuarioActual instanceof Basico && ((Basico)usuarioActual).getActualizar() == true){
            if(usuarios.contains(usuarioActual)){
                usuarios.remove(usuarioActual);
            }
            usuarioActual = new Premium(((Basico) usuarioActual).getNombre(), ((Basico) usuarioActual).getContrasena());
            ((Premium) usuarioActual).setReserva(reserva);
            usuarios.add(usuarioActual);
        }

        if(((Usuario) usuarioActual).getCambioDeContra()){
            System.out.println("\nIngrese su nueva contraseña:");
            String contrasena = scan.nextLine();
            System.out.println("\nSe ha actualizado correctamente su contraseña");
            System.out.println("\nSe regresara al menu principal para actualizar los cambios");
            if(usuarios.contains(usuarioActual)){
                usuarios.remove(usuarioActual);
            }
            ((Usuario) usuarioActual).setContrasena(contrasena);
            usuarios.add(usuarioActual);
        }

        guardarCSVUsuarios(usuarios);
        return usuarioActual;
    }

    public static void guardarCSVUsuarios(ArrayList<Paquete> usuarios){
        File archivoCSV = new File("usuarios.csv");//Se prepara el archivo que se creara

        try{
            PrintWriter out = new PrintWriter(archivoCSV);//Para escribir en el archivo

            String[] titulos = {"Nombre", "Contraseña", "Plan"};

            for(String titulo : titulos)
                out.print(titulo + ";");//Escribimos los titulos

            out.println();

            for(Paquete usuario : usuarios){
                if(usuario instanceof Basico)
                    out.println(((Usuario) usuario).toCSV()+"Basico");//Por cada usuario en la lista, se escriben sus respectivos datos en el CSV
                else
                    out.println(((Usuario) usuario).toCSV()+"Premium");
            }

            out.close();//Cerramos y guardamos el archivo

            System.out.println("\nArchivo usuarios.csv guardado correctamente....");
        }catch(FileNotFoundException e){//En caso de que no se pueda crear
            System.out.println("No se ha encontrado el archivo");
        }
    }

    public static void guardarCSVReservas(ArrayList<Reserva> reservas){
        File archivoCSV = new File("reservas.csv");//Se prepara el archivo que se creara

        try{
            PrintWriter out = new PrintWriter(archivoCSV);//Para escribir en el archivo

            String[] titulos = {"Fecha", "Modo", "Cuotas", "Clase", "Boletos", "Aerolinea", "Cupon", "Asiento", "Maletas"};

            for(String titulo : titulos)
                out.print(titulo + ";");//Escribimos los titulos

            out.println();

            for(Reserva reserva : reservas){
                out.println(reserva.toCSV());
            }

            out.close();//Cerramos y guardamos el archivo

            System.out.println("\nArchivo reservas.csv guardado correctamente....");
        }catch(FileNotFoundException e){//En caso de que no se pueda crear
            System.out.println("No se ha encontrado el archivo");
        }
    }

    /*REFLEXION: 
     * Haber trabajado con una interfaz grupal fue bastante interesante, me permitio ver el resto de formas de como programan los demas. 
     * Aun asi, se presentaron algunos problemas, y todo se pudo haber solucionado si inicialmente hubieramos planeado haber puesto
     * listas de reservas y usuarios como parametros, pero ni a mi ni a mi grupo se nos ocurrio pero solo ese detalle siento que complico, 
     * aun asi, haber hecho la interfaz en grupo ayudo bastante, ya que en general, de no ser por eso de las listas, la interfaz estaba
     * muy bien pensada. 
     */
}