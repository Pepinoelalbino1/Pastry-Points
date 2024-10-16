import java.sql.Connection;
import java.sql.SQLException;

public class PPPP1 {
    public static void main(String[] args) {
        // Obtener la instancia de Conexion y la conexión
        Conexion conexion = Conexion.getInstance();
        Connection connection = conexion.getConnection();
        
        // Verificar si la conexión fue exitosa
        if (connection != null) {
            // Crear instancia del Facade y pasar la conexión
            PastelFacade pastelFacade = new PastelFacade(connection);

            // Llamar al método para gestionar calificación
            pastelFacade.gestionarCalificacion();

            // Preguntar si desea agregar un pastel
            pastelFacade.gestionarAgregarPastel();
            
            // Preguntar si desea comprar un pastel
            pastelFacade.gestionarComprarPastel();
            // Cerrar la conexión después de usarla
            try {
                connection.close(); // Asegúrate de cerrar la conexión cuando termines
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}