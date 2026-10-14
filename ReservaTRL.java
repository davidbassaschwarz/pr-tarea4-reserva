public class ReservaTRL extends Reserva {

	private static final String ELEMENTO = "Reserva Traslado";
	private static final String TIPO = "TRL";

	private static int numReserva;
	static {
		ReservaTRL.numReserva = 0;
	} // numReserva

	private String recogida;
	private String destino;

	private static String generaNumReserva() {
		return Reserva.Localizador.generar(ReservaTRL.TIPO, ++ReservaTRL.numReserva);
	} // generaNumReserva

	public static int getNumReserva() {
		return ReservaTRL.numReserva;
	} // getNumReserva

	public ReservaTRL(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, String recogida, String destino, int neto) {
		super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);
		this.recogida = recogida;
		this.destino = destino;
		this.numReservas = ReservaTRL.generaNumReserva();
	} // constructorReservaTRL

	public String getRecogida() {
		return recogida;
	}
	public void setRecogida(String recogida) {
		this.recogida = recogida;
	}

	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void muestraReserva() {
		super.muestraReserva();
		System.out.println(ReservaTRL.ELEMENTO);
		System.out.println("Número de Reserva: " + this.numReservas);
		System.out.println("Lugar de Recogida: " + this.recogida);
		System.out.println("Lugar de Destino: " + this.destino);
	} // muestraReserva

} // class ReservaTRL
