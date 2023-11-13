/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 13/12/2023 9:06
*/

public abstract class Usuario{

    protected String nombre;
    protected String contrasena; 
    protected Reserva reserva;

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
        return "";
    }

    public Usuario(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
}