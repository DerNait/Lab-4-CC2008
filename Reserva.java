/*
Kevin Josué Villagrán Mérida - 23584
Laboratorio #4 
Fecha de creación: 12/11/2023 22:15
Fecha de ultima modificación: 17/11/2023 11:36
*/

public class Reserva{

    private String fecha;
    private String modo;
    private int cuotas;
    private String clase = null;
    private int boletos;
    private String aerolinea;
    private String cupon = "No hay cupon aplicado"; //Este atributo no estaba inicialmente, pero lo puse porque al hacer el diseño no vi el tema de los cupones, pero nada mas es un pequeño detalle de las reservas
    private int asiento;
    private int maletas;    

    @Override
    public String toString(){//Mostramos los datos a detalle segun la situacion
        if(clase == null)
            return "\n=== Datos de la reserva ===" +
            "\nFecha: " + fecha +
            "\nModo: " + modo +
            "\nCantidad de boletos: " + boletos +
            "\nAerolinea: " + aerolinea;
        else
            return "\n=== Datos del pago ===" +
            "\nClase: " + clase +
            "\nCantidad de maletas: " + maletas +
            "\nNumero de asiento: " + asiento +
            "\nCantidad de cuotas: " + cuotas +
            "\nCupon aplicado: " + cupon;
    }


    /*A diferencia de lo puesto en el diseño, tuve que agregar setters pues se dieron unos pequeños imprevistos, que se pudieron solucionar
    modificando la interfaz, pero esta solucion es mejor pues no modifica la interfaz y funciona bien, por eso es que tuve que agregar setters
    que originalmente no estaban planeados */
    public void setCupon(String cupon) {
        this.cupon = cupon;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public void setMaletas(int maletas) {
        this.maletas = maletas;
    }

    public String toCSV(){
        return fecha + ";" + modo + ";" + cuotas + ";" + clase + ";" + boletos + ";" + aerolinea + ";" + cupon + ";" + asiento +";" + maletas;
    }

    public Reserva(String fecha, String modo, int boletos, String aerolinea, String cupon, int cuotas, String clase, int asiento, int maletas){
        this.fecha = fecha;
        this.modo = modo;
        this.boletos = boletos;
        this.aerolinea = aerolinea;
        this.cupon = cupon;
        this.cuotas = cuotas;
        this.clase = clase;
        this.asiento = asiento;
        this.maletas = maletas;
    }
}