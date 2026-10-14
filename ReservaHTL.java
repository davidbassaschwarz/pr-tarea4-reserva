public class ReservaHTL extends Reserva {
    
    private static final String ELEMENTO = "Reserva Hotel";
    private static final String TIPO = "HTL";

    private static int numReserva;
    static {
        ReservaHTL.numReserva = 0;
    } // numReserva

    private String direccion = "Palma de Mallorca";
    private char tipoHab = '\0';

    private static String generaNumReserva() {
        return Reserva.Localizador.generar(ReservaHTL.TIPO, ++ReservaHTL.numReserva);
    } // generaNumReserva

    public static int getNumReserva() {
        return ReservaHTL.numReserva;
    } // numReserva

    public ReservaHTL(String pax1, String pax2, String pax3, String pax4, String fechaInicio, String fechaFin, String direccion, char habitacion, int precioNeto) {
        super(pax1, pax2, pax3, pax4, fechaInicio, fechaFin, precioNeto);
        this.direccion = direccion;
        this.tipoHab = habitacion;
        this.numReservas = ReservaHTL.generaNumReserva();
    } // constructorReservaHTL

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getTipoHab() {
        return tipoHab;
    }
    public void setTipoHab(char tipoHab) {
        this.tipoHab = tipoHab;
    }

    public void muestraReserva() {
        super.muestraReserva();
        System.out.println(ReservaHTL.ELEMENTO);
        System.out.println("Número de reserva: " + this.numReservas);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Tipo de habitación: " + this.tipoHab);
    } // muestraReserva
} // class ReservaHTL
