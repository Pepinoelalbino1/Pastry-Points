package Codigo;

import Codigo.IUser;
import Codigo.IPastelData;
import java.sql.Connection;

public class IngresarPastel {
    private IPastelData pastelData;
    private IUser inputHandler;

    public IngresarPastel(Connection connection) {
        this.pastelData = new IPastelData(connection);
        this.inputHandler = new IUser();
    }

    public void agregarCalificacion() {
        int idPastel = inputHandler.obtenerIdPastel();

        // Obtener el nombre del pastel
        String nombrePastel = pastelData.obtenerNombrePastel(idPastel);
        if (nombrePastel == null) {
            System.out.println("El ID ingresado no corresponde a ningún pastel.");
            return; // Finaliza el método si no se encontró el pastel
        }

        // Obtener la descripción del pastel
        String descripcion = pastelData.obtenerDescripcionPastel(idPastel);

        // Preguntar si recomendaría el pastel
        String respuesta = inputHandler.preguntarRecomendacion(nombrePastel, descripcion, idPastel);

        // Determinar el cambio en la calificación
        int cambioCalificacion = (respuesta.equals("si")) ? 1 : -1;

        // Actualizar la calificación en la base de datos
        pastelData.actualizarCalificacion(idPastel, cambioCalificacion);
        System.out.println("\nGracias por opinar, tome un dulce porfavor :)");
        System.out.println("-----------------------------------------------");
    }
}