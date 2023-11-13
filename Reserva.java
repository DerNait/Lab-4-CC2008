/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 13/12/2023 9:06
*/

public class Reserva{

    private String fecha;
    private String modo;
    private int cuotas;
    private String clase;
    private int boletos;
    private String aerolinea;
    private int asiento;
    private int maletas;    

    @Override
    public String toString(){
        return "";
    }

    public String toCSV(){
        return "";
    }

    public Reserva(String fecha, String modo, int cuotas, String clase, int boletos, String aerolinea, int asiento, int maletas){
        this.fecha = fecha;
        this.modo = modo;
        this.cuotas = cuotas;
        this.clase = clase;
        this.boletos = boletos;
        this.aerolinea = aerolinea;
        this.asiento = asiento;
        this.maletas = maletas;
    }
}