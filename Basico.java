/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 13/12/2023 9:06
*/

public class Basico extends Usuario implements Paquete{

    @Override
    public void reservaViaje(){

    }

    @Override
    public void confirmacionPago(){

    }

    @Override
    public int seleccionAsiento(){
        return 1;
    }

    @Override
    public int cantidadMaletas(){
        return 1;
    }

    @Override
    public void modificarPerfil(){

    }

    public Basico(String nombre, String contrasena){
        super(nombre, contrasena);
    }
}