public class Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("     SISTEMA DE GESTIÓN DE RESERVAS TURÍSTICAS    ");
        System.out.println("==================================================\n");

        // 1. Reserva de Vuelo de ida (PMI -> MAD)
        ReservaVUE vueloIda = new ReservaVUE(
            "David Bassa", "Marc Millan", null, null,
            "2026-07-01", "2026-07-01",
            "PMI", "MAD",
            120
        );

        // 2. Reserva de Traslado desde el aeropuerto de Madrid al hotel
        ReservaTRL trasladoLlegada = new ReservaTRL(
            "David Bassa", "Marc Millan", null, null,
            "2026-07-01", "2026-07-01",
            "Aeropuerto Adolfo Suárez Madrid-Barajas (MAD)", 
            "Hotel Gran Vía, Calle Gran Vía 25, Madrid",
            40
        );

        // 3. Reserva de Hotel (Estancia de 5 noches en habitación doble)
        ReservaHTL hotel = new ReservaHTL(
            "David Bassa", "Marc Millan", null, null,
            "2026-07-01", "2026-07-06",
            "Calle Gran Vía 25, Madrid",
            'D', // Habitación Doble
            450
        );

        // 4. Reserva de Traslado de salida (Hotel -> Aeropuerto)
        ReservaTRL trasladoSalida = new ReservaTRL(
            "David Bassa", "Marc Millan", null, null,
            "2026-07-06", "2026-07-06",
            "Hotel Gran Vía, Calle Gran Vía 25, Madrid",
            "Aeropuerto Adolfo Suárez Madrid-Barajas (MAD)",
            40
        );

        // 5. Reserva de Vuelo de vuelta (MAD -> PMI)
        ReservaVUE vueloVuelta = new ReservaVUE(
            "David Bassa", "Marc Millan", null, null,
            "2026-07-06", "2026-07-06",
            "MAD", "PMI",
            110
        );

        // Uso de Polimorfismo: almacenamos los distintos tipos de reserva en un array de la superclase
        Reserva[] itinerario = { vueloIda, trasladoLlegada, hotel, trasladoSalida, vueloVuelta };

        int totalBrutoExpediente = 0;

        for (int i = 0; i < itinerario.length; i++) {
            System.out.println("--------------------------------------------------");
            System.out.println("Item #" + (i + 1) + " del Itinerario:");
            itinerario[i].muestraReserva();
            totalBrutoExpediente += itinerario[i].getPrecioBruto();
            System.out.println();
        }

        System.out.println("==================================================");
        System.out.println("TOTAL EXPEDIENTE DE VIAJE (IVA incl.): " + totalBrutoExpediente + " €");
        System.out.println("Total reservas Hotel generadas: " + ReservaHTL.getNumReserva());
        System.out.println("Total reservas Vuelo generadas: " + ReservaVUE.getNumReserva());
        System.out.println("Total reservas Traslado generadas: " + ReservaTRL.getNumReserva());
        System.out.println("==================================================");
    }
}
