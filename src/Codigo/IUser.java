package Codigo;

import java.util.Scanner;

public class IUser {
    Scanner scanner;

    public IUser() {
        this.scanner = new Scanner(System.in);
    }

    public int obtenerIdPastel() {
        System.out.print("Ingrese el ID del pastel (1-4): ");
        System.out.println("\n--------------------------------------");
        System.out.print("ID: ");
        return scanner.nextInt();
    }

    public String preguntarRecomendacion(String nombrePastel, String descripcion, int idPastel) {
        System.out.println("Pastel: " + nombrePastel);
        System.out.println("Descripción: " + descripcion); // Muestra la descripción
        System.out.println("--------------------------------------");
        System.out.print("¿Recomendarías el pastel " + idPastel + " (" + nombrePastel + ")? (si/no): ");
        return scanner.next().toLowerCase();
    }

    public void cerrarScanner() {
        scanner.close();
    }
}