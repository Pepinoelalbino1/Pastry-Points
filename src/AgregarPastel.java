import java.math.BigDecimal;
import java.util.Scanner;

public class AgregarPastel {
    private APastelManager pastelManager;
    private Scanner scanner;

    public AgregarPastel(APastelManager pastelManager) {
        this.pastelManager = pastelManager;
        this.scanner = new Scanner(System.in);
    }

    public void agregarNuevoPastel() {
        System.out.print("Ingrese el nombre del pastel: ");
        String nombre = scanner.nextLine();

        System.out.print("¿Es dietético? (true/false): ");
        boolean dietFriendly = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer

        BigDecimal precio = null;
        while (precio == null) {
            try {
                System.out.print("Ingrese el precio del pastel (ejemplo: 30.00): ");
                String precioInput = scanner.nextLine(); // Leer como cadena
                precio = new BigDecimal(precioInput); // Convertir a BigDecimal
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un precio válido (ejemplo: 30.00).");
            }
        }

        // Obtener el ID del pastel agregado
        int idPastel = pastelManager.agregarPastel(nombre, dietFriendly, precio);

        System.out.print("¿Desea agregar una descripción? (si/no): ");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("si")) {
            System.out.print("Ingrese la descripción: ");
            String descripcion = scanner.nextLine();

            pastelManager.agregarDescripcion(idPastel, descripcion); // Usar el ID obtenido
        }
    }

    public void cerrarScanner() {
        scanner.close();
    }
}