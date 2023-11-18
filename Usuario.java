/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 17/11/2023 11:36
*/

import java.util.ArrayList;

public abstract class Usuario{

    protected String nombre;
    protected String contrasena; 
    protected Reserva reserva;
    protected boolean cambioDeContra = false; //Este atributo es nuevo, ya que si se penso bastante bien pero no tomamos en cuenta la forma en la que hariamos el cambio de contraseña, pero este cambio termino ayudando mas

    @Override
    public String toString(){
        return "";
    }

    public String getNombre(){
        return nombre;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    public Reserva getReserva(){
        return reserva;
    }

    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    public String toCSV(){
        return nombre + ";" + contrasena + ";";
    }

    public boolean getCambioDeContra() {
        return cambioDeContra;
    }

    public Usuario(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
}