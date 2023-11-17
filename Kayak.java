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
                        Premium premium = new Premium(usuariosData[0], usuariosData[1];);
                        usuarios.add(premium);
                        break;
                }
            }
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

            switch(seleccion){//Depende de la seleccion del jugador, se hace cada opcion del menu
                case "1":
                    registrarUsuario();
                    pass = true;
                    break;
                case "2":
                    ingresarUsuario();
                    pass = true;
                    break;
                case "3":

                    salir = true;
                    break;
                default://Si mete un valor invalido
                    System.out.println("Ingrese un valor numerico valido");
            }    
        }

            System.out.println("\n¡Usuario ingresado correctamente!");

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
                    hacerReserva();
                    break;
                case "2":
                    confirmarReserva();
                    break;
                case "3":
                    modificarPerfil();
                    break;                    
                case "4":

                    salir = true;
                    break;
                default://Si mete un valor invalido
                    System.out.println("Ingrese un valor numerico valido");
            } 
        }   
    }

    public static void registrarUsuario(ArrayList<Paquete> usuarios){
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
                Basico basico = new Basico(nombre, contrasena);
                usuarios.add(basico);
                System.out.println("Usuario registrado correctamente");
                break;
            case "2":
                System.out.println("\nHas escogido plan Premium");
                Premium premium = new Premium(nombre, contrasena);
                usuarios.add(premium);
                System.out.println("Usuario registrado correctamente");
                break;
            default: 
                System.out.println("Ingrese un valor numerico valido");
        }
    }

    public static void ingresarUsuario(){
        
    }

    public static void hacerReserva(){

    }

    public static void confirmarReserva(){

    }

    public static void modificarPerfil(){

    }
}