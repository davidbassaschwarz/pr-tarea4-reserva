public class ReservaVUE extends Reserva {

	private static final String ELEMENTO = "Reserva Vuelo";
	private static final String TIPO = "VUE";

	private static int numReserva;
	static {
		ReservaVUE.numReserva = 0;
	} // numReserva

	private String apSalida = "PMI";
	private String apLlegada;

	private static String generaNumReserva() {
		return Reserva.Localizador.generar(ReservaVUE.TIPO, ++ReservaVUE.numReserva);
	} // generaNumReserva

	public static int getNumReserva() {
		return ReservaVUE.numReserva;
	} // getNumReserva

	public ReservaVUE(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, String apSalida, String apLlegada, int neto) {
		super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);
		this.apSalida = apSalida.toUpperCase();
		this.apLlegada = apLlegada.toUpperCase();
		this.numReservas = ReservaVUE.generaNumReserva();
	} // constructorReservaVUE

	public String getApSalida() {
		return apSalida;
	}
	public void setApSalida(String apSalida) {
		this.apSalida = apSalida;
	}

	public String getApLlegada() {
		return apLlegada;
	}
	public void setApLlegada(String apLlegada) {
		this.apLlegada = apLlegada;
	}

	public void muestraReserva() {
		super.muestraReserva();
		System.out.println(ReservaVUE.ELEMENTO);
		System.out.println("Número de Reserva: " + this.numReservas);
		System.out.println("A/P Salida : " + this.apSalida);
		System.out.println("A/P Llegada : " + this.apLlegada);
	} // muestraReserva
} // class ReservaVUE
