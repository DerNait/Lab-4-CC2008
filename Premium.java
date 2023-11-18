/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 13/12/2023 9:06
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Premium extends Usuario implements Paquete{

    @Override
    public void reservaViaje(){
        String fecha;
        String modo;
        int boletos = 0;
        String aerolinea;
        
        Scanner scan = new Scanner(System.in);
        boolean anException = false;

        System.out.println("\n=== RESERVA ===");
        System.out.println("Defina la fecha del viaje con el siguiente formato: DD/MM/YYYY; Ejemplo: 10/10/2023");
        fecha = scan.nextLine();
        System.out.println("Defina si es ida y vuelta o solo ida (Introduzca valores numericos): 1. Ida y vuelta, 2. Solo ida");
        modo = scan.nextLine();
        switch (modo) {
            case "1":
                modo = "Ida y vuelta";
                break;
            case "2":
                modo = "Solo ida";
                break;
            default:
                System.out.println("Introduzca un numerico valido entre 1 y 2");
                break;
        }

        System.out.println("Seleccionado: " + modo);

        do{//Ciclo que se interrumpe solo si no hay un error en el dato que introduce el usuario
                    System.out.println("Ingrese la cantidad de boletos que desea: ");
                try{
                    boletos = Integer.parseInt(scan.nextLine());//Se almacena el dato del ID
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
        } while(anException);
        System.out.println("Defina la aerolinea en la que desea viajar");
        aerolinea = scan.nextLine();

        reserva = new Reserva(fecha,modo,boletos,aerolinea, "No hay cupon aplicado", 0, null, 0, 0);
        System.out.println(reserva);
    }

    public void confirmacionPago(ArrayList<Reserva> reservas){
        int cuotas = 1; 
        String clase; 
        int maletas = 0;
        String tarjeta;
        
        Scanner scan = new Scanner(System.in);

        if(reserva == null){
            System.out.println("\nAun no has hecho tu reserva. Haz una reserva para confirmar el pago");
            return;
        }

        System.out.println("\n=== CONFIRMAR RESERVA ===");
        System.out.println("Escriba el numero de su tarjeta");
        tarjeta = scan.nextLine();

        clase = "Primera clase";

        reserva.setAsiento(seleccionAsiento());
        reserva.setClase(clase);
        reserva.setCuotas(cuotas);
        reserva.setMaletas(cantidadMaletas());
        System.out.println(reserva);
        reservas.add(reserva);     
    }

    @Override
    public int seleccionAsiento(){
        int asiento = 1;
        Scanner scan = new Scanner(System.in);
        boolean anException = false;

        do{//Ciclo que se interrumpe solo si no hay un error en el dato que introduce el usuario
            System.out.println("\nIngrese el numero de asiento que desea: ");
            try{
                asiento = Integer.parseInt(scan.nextLine());//Se almacena el dato del ID
                anException = false;
            }catch(Exception e){
                System.out.println("\nIntroduzca un valor numerico valido, asegurese de que sean no mas de 24 cuotas");
                anException = true;
            }
        } while(anException); 

        return asiento;
    }

    @Override
    public int cantidadMaletas(){
        int maletas = 1;
        Scanner scan = new Scanner(System.in);
        boolean anException = false;

        do{//Ciclo que se interrumpe solo si no hay un error en el dato que introduce el usuario
            System.out.println("\nIngrese el numero de maletas que llevara: ");
            try{
                maletas = Integer.parseInt(scan.nextLine());//Se almacena el dato del ID
                anException = false;
            }catch(Exception e){
                System.out.println("\nIntroduzca un valor numerico valido, asegurese de que sean no mas de 24 cuotas");
                anException = true;
            }
        } while(anException); 

        return maletas;
    }

    @Override
    public void modificarPerfil(){
        boolean salir = false;//Permite salir del programa
        String seleccion;
        Scanner scan = new Scanner(System.in);

        while(!salir){//Menu de opciones del usuario
            System.out.println("\n=== MODIFICAR PERFIL ===");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Cambiar contraseña");   
            System.out.println("2. Regresar");

            seleccion = scan.nextLine();

            switch(seleccion){//Depende de la seleccion del usuario, se hace cada opcion del menu
                case "1":
                    cambioDeContra = true;
                    return;                    
                case "2":
                    salir = true;
                    break;
                default://Si mete un valor invalido
                    System.out.println("Ingrese un valor numerico valido");
            } 
        } 
    }

    public Premium(String nombre, String contrasena){
        super(nombre, contrasena);
    }
}