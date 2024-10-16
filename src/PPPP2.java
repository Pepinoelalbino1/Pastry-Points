import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class PPPP2 {
    public static void main(String[] args) {
        // Obtener la instancia de Conexion y la conexión
        Conexion conexion = Conexion.getInstance();
        Connection connection = conexion.getConnection();
        
        if (connection != null) {
            // Crear instancia del Facade y pasar la conexión
            PastelFacade pastelFacade = new PastelFacade(connection);
            
            Scanner scanner = new Scanner(System.in);
            String input = "";

            while (true) {
                System.out.print("Ingrese una palabra de usuario ('cli' para cliente o 'adm' para administrador): ");
                input = scanner.nextLine();

                if (input.equals("cli")) {
                    pastelFacade.gestionarCalificacion();
                    pastelFacade.gestionarComprarPastel();
                    break;  // Salir del bucle después de ejecutar las funciones
                } else if (input.equals("adm")) {
                    pastelFacade.gestionarAgregarPastel();
                    break;  // Salir del bucle después de ejecutar las funciones
                } else {
                    System.out.println("\nPalabra no válida. Intente de nuevo.");
                    System.out.println("-----------------------------------------------");
                }
            }

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


//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class PPPP1 {
//    public static void main(String[] args) {
//        // Obtener la instancia de Conexion y la conexión
//        Conexion conexion = Conexion.getInstance();
//        Connection connection = conexion.getConnection();
//        
//        // Verificar si la conexión fue exitosa
//        if (connection != null) {
//            // Crear instancia del Facade y pasar la conexión
//            PastelFacade pastelFacade = new PastelFacade(connection);
//
//            // Llamar al método para gestionar calificación
//            pastelFacade.gestionarCalificacion();
//
//            // Preguntar si desea agregar un pastel
//            pastelFacade.gestionarAgregarPastel();
//            
//            // Preguntar si desea comprar un pastel
//            pastelFacade.gestionarComprarPastel();
//            // Cerrar la conexión después de usarla
//            try {
//                connection.close(); // Asegúrate de cerrar la conexión cuando termines
//                System.out.println("Conexión cerrada.");
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar la conexión: " + e.getMessage());
//            }
//        } else {
//            System.out.println("No se pudo establecer la conexión a la base de datos.");
//        }
//    }
//}