/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 17/11/2023 11:36
*/

import java.util.ArrayList;

public interface Paquete{

    public void reservaViaje();

    public void confirmacionPago(ArrayList<Reserva> reservas);

    public int seleccionAsiento();

    public int cantidadMaletas();

    public void modificarPerfil();
}