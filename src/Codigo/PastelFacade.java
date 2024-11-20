package Codigo;

import Codigo.IngresarPastel;
import Codigo.IUser;
import Codigo.IPastelData;
import Codigo.AgregarPastel;
import Codigo.APastelManager;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Scanner;

public class PastelFacade {
    private Connection connection;
    private IUser inputHandler;
    private IngresarPastel ingresarPastel;

    public PastelFacade(Connection connection) {
        this.connection = connection;
        this.inputHandler = new IUser();
        this.ingresarPastel = new IngresarPastel(connection);
    }

    public void gestionarCalificacion() {
        ingresarPastel.agregarCalificacion();
    }

    public void gestionarAgregarPastel() {
        System.out.print("¿Desea agregar algún pastel como administrador? (si/no): ");
        String respuesta = inputHandler.scanner.next().toLowerCase();

        if (respuesta.equals("si")) {
            AgregarPastel agregarPastel = new AgregarPastel(new APastelManager(connection));
            agregarPastel.agregarNuevoPastel();
        } else {
            System.out.println("¡Que tenga un buen día!");
        }
    }
    public void gestionarComprarPastel() {
    System.out.print("¿Desea comprar un pastel? (si/no): ");
    String respuesta = inputHandler.scanner.next().toLowerCase();

    if (respuesta.equals("si")) {
        System.out.print("Ingrese el ID del pastel que desea comprar: ");
        int idPastel = inputHandler.scanner.nextInt();

        System.out.print("Ingrese la cantidad que desea comprar: ");
        int cantidad = inputHandler.scanner.nextInt();

        // Obtener el precio del pastel
        IPastelData pastelData = new IPastelData(connection);
        String nombrePastel = pastelData.obtenerNombrePastel(idPastel);
        BigDecimal precio = pastelData.obtenerPrecioPastel(idPastel); 

        if (nombrePastel != null && precio != null) {
            // Calcular el precio total
            BigDecimal precioTotal = precio.multiply(new BigDecimal(cantidad));
            System.out.println("Has comprado " + cantidad + " unidades del pastel '" + nombrePastel + "'.");
            System.out.println("El precio total es: $" + precioTotal);
        } else {
            System.out.println("Error: No se pudo obtener el pastel con ID " + idPastel);
        }
    } else {
        System.out.println("¡Que tenga un buen día!");
    }
}
    
}