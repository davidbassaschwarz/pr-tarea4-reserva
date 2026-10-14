import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    // EJERCICIO CLASES Y OBJETOS.

		// En leccion_10_Ejercicio está resuelto con estructura correcta de Package

		// Se trata de diseñar una Class "Reserva" aplicando la mayoría de los conceptos
		// vistos hasta el momento
		//
		// La Class Reserva tiene como atributos comunes:
		// Número de reserva; compuesto por "Tipo/Año/Número";
		// Tipo; HTL si es de Hotel, VUE si es un vuelo, TRL si es un traslado
		// Año; Año en curso (del momento de la reserva, no de la fecha de consumo)
		// Número; Es un número consecutivo del tipo de reserva
		// Ejemplos: "HTL/2024/0001", "HTL/2024/0002", "VUE/2024/001",
		// "TRL/2024/0001",...
		// Pax; máximo 4 Ejemplo; [Tomeu Sabater, Juan Pérez, Pep Gonella, Pepito Pérez]
		// Fecha de Inicio/Llegada y Fecha de Fin/Salida; Ejemplo: 01-Agosto-2026,
		// 05-Agosto-2026
		// Precio sin Impuestos y Precios con Impuestos (IVA 21%); Ejemplo: 1.000, 1.210
		//
		// Atributos particulares:
		// Si es HTL:
		// Dirección; Dirección postal del hotel
		// Tipo de Habitación: [S]imple, [D]oble, [T]riple
		// Si es VUE:
		// A/P de salida: Código 3 letras aeropuerto de salida: PMI, BCN, CUN, HAV
		// A/P de llegada: Código 3 letras aeropuerto de llegada: MAD, SVQ, JFK, ATL
		// Si es TRL:
		// Recogida: Lugar de Recogida, es una dirección postal
		// Destino: Lugar de Destino, es una dirección postal
		//
		// Tiene que haber un método constructor
		// Tiene que haber Getters y Setters para cada variable de instancia
		// Tiene que haber un método que muestra el contenido de la reserva
		// Típicamente, habría 5 reservas: 2 x vuelo (ida/vuelta), 2 x traslado (a/p ->
		// hotel, hotel -> a/p), 1 x hotel
		// Los pasajeros toman un Vuelo desde el A/P origen al A/P destino (reserva 1),
		// a la llegada toman un Traslado cuyo destino es el Hotel (reserva 2),
		// una vez finalizada la estancia en el Hotel (reserva 3) toman un Traslado
		// hasta el A/P destino (reserva 4) donde un Vuelo los devuelve al A/P origen
		// (reserva 5)
		//
		// Nota: En la realidad, existen más elementos, por ejemplo el seguro de viaje y
		// entradas a museos, parques temáticos y otras atracciones, todo ello se
		// almacena en un único expediente, no trataremos esta estructura
		// por el momento, nos limitamos a Reservas independientes.

		// Se muestra una aproximación (no tiene todas las Sub Class) a una posible
		// Solución:

		// Diseñaremos una Super Class Reserva que contendrá los elementos comunes
		// y 3 Sub Class, para HTL, VUE y TRL cada una con los elemento que les sea
		// particular
		// Nota: Sería adecuado tener el diagrama de Clases antes de empezar

    private static final String ELEMENTO = "Reserva";
    private static final byte MAX_NUM_PAX = 4;
    private static final byte IVA = 21;

    protected String numReservas= null;

	private Pax[] pasajeros = new Pax[Reserva.MAX_NUM_PAX];

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private int precioNeto = 0;
    private int precioBruto = 0;

    public Reserva(String pax1, String pax2, String pax3, String pax4, String fechaInicio, String fechaFin, int precioNeto) {
        if (pax1 != null) this.pasajeros[0] = new Pax("00000000A", pax1, "", "", "2000-01-01");
        if (pax2 != null) this.pasajeros[1] = new Pax("00000000B", pax2, "", "", "2000-01-01");
        if (pax3 != null) this.pasajeros[2] = new Pax("00000000C", pax3, "", "", "2000-01-01");
        if (pax4 != null) this.pasajeros[3] = new Pax("00000000D", pax4, "", "", "2000-01-01");

        this.fechaInicio = LocalDate.parse(fechaInicio);
        this.fechaFin = LocalDate.parse(fechaFin);

        this.precioNeto = precioNeto;
        this.precioBruto = this.calcularBruto(this.precioNeto);

    } // constructorReserva

    public String getNumReservas() {
        return numReservas;
    }
    public void setNumReservas(String numReservas) {
        this.numReservas = numReservas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPrecioNeto() {
        return precioNeto;
    }
    public void setPrecioNeto(int precioNeto) {
        this.precioNeto = precioNeto;
    }

    public int getPrecioBruto() {
        return precioBruto;
    }
    public void setPrecioBruto(int precioBruto) {
        this.precioBruto = precioBruto;
    }

	private int calcularBruto(int neto) {
		return (neto + ((neto * Reserva.IVA) / 100));
	} // calcularBruto

	public void muestraFecha() {
		System.out.println("Fecha inicio: " + this.fechaInicio);
		System.out.println("Fecha fin: " + this.fechaFin);
	} // muestraFecha


	// STATIC NESTED CLASS Localizador
	public static class Localizador {
		public static String generar(String tipo, int numero) {
			int año = LocalDate.now().getYear();
			return tipo + "/" + año + "/" + numero;
		} // generar
	} // class Localizador


	public void muestraReserva() {
		System.out.println(Reserva.ELEMENTO);
		for (Pax p : this.pasajeros) {
    		if (p != null) p.muestraPax();
		}

		muestraFecha();
		System.out.println("Precio Neto: " + this.precioNeto);
		System.out.println("Precio Bruto: " + this.precioBruto);								
	} // muestraReserva


	// INNER CLASS Pasajeros
    private class Pax {
        private static final String ELEMENTO = "Pasajero";
		private static final byte MIN_ADULT_YEARS = 18;

		private String pasaporte = null;

		private String nombre = null;
		private String apellido1 = null;
		private String apellido2 = null;

		private LocalDate fechaNacimiento;


		public Pax(String pasaporte, String nombre, String apellido1, String apellido2, String fechaNacimiento) {

			this.pasaporte = pasaporte;
			this.nombre = nombre.toUpperCase();
			this.apellido1 = apellido1.toUpperCase();
			this.apellido2 = (apellido2 != null) ? apellido2.toUpperCase() : null;

			this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
		} // constructorPax
		
		public void muestraPax() {
			System.out.println(Pax.ELEMENTO);
			System.out.println("Passport cliente :" + this.pasaporte);
			System.out.println("Cliente adulto :" + this.esAdulto());
			System.out.println("Nombre :" + this.nombre);
			System.out.println("Apellido1 : " + this.apellido1);
			System.out.println("Apellido2 : " + this.apellido2);
			System.out.println("Fecha nacimiento : " + this.fechaNacimiento);
		} // muestraPax

		private boolean esAdulto() {

			long años = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
			return (años >= Pax.MIN_ADULT_YEARS) ? true : false;
		} // esAdulto
	} // class Pasajeros
} // class Reserva